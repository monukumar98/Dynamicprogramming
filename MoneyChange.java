package Dynamicprogramming;

import java.util.Scanner;

public class MoneyChange {
	static int mod = 1_0000_000_00 + 7;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int money[] = new int[m];
			for (int i = 0; i < m; i++) {
				money[i] = sc.nextInt();
			}
			int n = sc.nextInt();
			// int dp[][] = new int[n + 5][m + 5];
			// System.out.println(moneychanges(money, n, 0, dp));
			System.out.println(moneyChangesBU(money, n));
		}
	}

	public static int moneychanges(int[] money, int n, int i, int[][] dp) {
		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			return 0;
		}
		if (i == money.length && n >= 1) {
			return 0;
		}
		if (dp[n][i] != 0) {
			return dp[n][i];
		}
		return dp[n][i] = ((moneychanges(money, n - money[i], i, dp)) % (1_0000_000_00 + 7)
				+ (moneychanges(money, n, i + 1, dp)) % (1_0000_000_00 + 7)) % 1000000007;

	}

	public static int moneyChangesBU(int money[], int n) {

		int dp[] = new int[n + 1];

		dp[0] = 1;

		dp[0] = 1;
		for (int i = 0; i < money.length; i++) {
			for (int j = 1; j <= n; j++) {
				if (money[i] <= j)
					dp[j] = ((dp[j] % mod) + (dp[j - money[i]] % mod)) % mod;
			}
		}
//		for (int i = 0; i <= n; i++) {
//			System.out.print(dp[i]+" ");
//		}
		System.out.println();
		return dp[n];

	}

}
