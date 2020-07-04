package Dynamicprogramming;

import java.util.Scanner;

public class MinimumCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int coin[] = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}
		int money = sc.nextInt();
		System.out.println(minicoin(coin, money));
		System.out.println(TDminicoin(coin, money, new int[money + 1]));
		System.out.println(BUminicoin(coin, money));

	}

	public static int minicoin(int coin[], int money) {
		if (money == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE - 1000;
		for (int i = 0; i < coin.length; i++) {
			if (money - coin[i] >= 0) {
				ans = Math.min(ans, minicoin(coin, money - coin[i]) + 1);
			}
		}
		return ans;
	}

	public static int TDminicoin(int coin[], int money, int dp[]) {
		if (money == 0) {
			return 0;
		}
		if (dp[money] != 0) {
			return dp[money];
		}
		int ans = Integer.MAX_VALUE - 1000;
		for (int i = 0; i < coin.length; i++) {
			if (money - coin[i] >= 0) {
				ans = Math.min(ans, minicoin(coin, money - coin[i]) + 1);
			}
		}
		return dp[money] = ans;
	}

	public static int BUminicoin(int coin[], int money) {
		int dp[] = new int[money + 1];
		for (int i = 1; i <= money; i++) {
			dp[i] = Integer.MAX_VALUE - 1000;
			
			for (int j = 0; j < coin.length; j++) {

				if (i >= coin[j]) {
					dp[i] = Math.min(dp[i - coin[j]] + 1, dp[i]);
				}
			}

		}

		return dp[money];
	}

}
