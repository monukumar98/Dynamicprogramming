package Dynamicprogramming;

import java.util.Scanner;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int price[] = { 0, 1, 50, 8, 90, 10, 17, 17, 20 };
		System.out.println(rodcutting(price, price.length - 1));
		System.out.println(TDrodcutting(price, price.length - 1, new int[price.length + 1]));
		System.out.println(BUrodcutting(price, price.length - 1));

	}

	public static int rodcutting(int[] price, int len) {
		// TODO Auto-generated method stub
		if (len == 0)
			return 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= price.length - 1; i++) {
			if (len >= i) {
				ans = Math.max(price[i] + rodcutting(price, len - i), ans);
			}
		}
		return ans;
	}

	public static int TDrodcutting(int[] price, int len, int dp[]) {
		// TODO Auto-generated method stub
		if (len == 0)
			return 0;
		if (dp[len] != 0) {
			return dp[len];
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= price.length - 1; i++) {
			if (len >= i) {
				ans = Math.max(price[i] + TDrodcutting(price, len - i, dp), ans);
			}
		}
		return dp[len] = ans;
	}

	public static int BUrodcutting(int[] price, int len) {
		// TODO Auto-generated method stub
		int dp[] = new int[price.length];
		dp[0] = 0;
		dp[1] = price[1];
		for (int i = 2; i <= price.length - 1; i++) {
			int ans = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {

				ans = Math.max(price[j] + dp[i-j], ans);
			}
			dp[i] = ans;
		}

		return dp[len];
	}
}
