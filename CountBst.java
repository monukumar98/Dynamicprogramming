package Dynamicprogramming;

import java.util.Scanner;

public class CountBst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(countBst(n));
			System.out.println(TDcountBst(n, new int[n + 1]));
			System.out.println(BUcountBst(n));
		}
	}

	public static int countBst(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = ans + (countBst(i - 1) * countBst(n - i));
		}
		return ans;
	}

	public static int TDcountBst(int n, int dp[]) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = ans + (TDcountBst(i - 1, dp) * TDcountBst(n - i, dp));
		}
		return dp[n] = ans;
	}

	public static int BUcountBst(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i] + dp[i - 1] * dp[n - i];
		}
		return dp[n];
	}

}
