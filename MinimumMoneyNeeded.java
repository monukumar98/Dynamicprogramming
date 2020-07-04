package Dynamicprogramming;

import java.util.Scanner;

public class MinimumMoneyNeeded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int val[] = new int[w];
		for (int i = 0; i < w; i++) {
			val[i] = sc.nextInt();
		}
		int wt[] = new int[val.length];
		for (int i = 0; i < val.length; i++) {
			if (val[i] != -1)
				wt[i] = i + 1;
			else
				wt[i] = 0;
		}
		int dp[][] = new int[w + 1][w + 1];
		System.out.println(MoneyNeeded(val, w, w, dp));

	}

	public static int MoneyNeeded(int arr[], int w, int n, int[][] dp) {
		if (w == 0) {
			return 0;
		}
		if (n == 0 && w == 0) {
			return 0;
		}
		if (w < 0) {
			return Integer.MAX_VALUE;
		}
		if (n == 0 && w > 0) {
			return Integer.MAX_VALUE;
		}
		if (dp[n][w] != 0) {
			return dp[n][w];
		}
		if (arr[n - 1] < 0) {
			return dp[n][w] = MoneyNeeded(arr, w, n - 1, dp);
		}
		if (w < n) {
			return dp[n][w] = MoneyNeeded(arr, w, n - 1, dp);
		}
		return dp[n][w] = Math.min(arr[n - 1] + MoneyNeeded(arr, w - n, n, dp), MoneyNeeded(arr, w, n - 1, dp));

	}

}
