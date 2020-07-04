package Dynamicprogramming;

import java.util.Scanner;

public class OptimalGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int dp[][] = new int[n + 5][n + 5];
		System.out.println(TDOptimalGame(arr, 0, arr.length - 1, dp));
		System.out.println(BUOptimalGame(arr));
	}

	public static int TDOptimalGame(int[] arr, int i, int j, int[][] dp) {
		if (i >= j) {
			return 0;
		}
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		if (j == i + 1) {
			return dp[i][j] = Math.max(arr[j], arr[i]);
		} else {
			int fn = Math.max(arr[i] + Math.min(TDOptimalGame(arr, i + 2, j, dp), TDOptimalGame(arr, i + 1, j - 1, dp)),
					arr[j] + Math.min(TDOptimalGame(arr, i + 1, j - 1, dp), TDOptimalGame(arr, i, j - 2, dp)));
			return dp[i][j] = fn;
		}
	}

	public static int OptimalGame(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (j == i + 1) {
			return Math.max(arr[j], arr[i]);
		} else {
			int fn = Math.max(arr[i] + Math.min(OptimalGame(arr, i + 2, j), OptimalGame(arr, i + 1, j - 1)),
					arr[j] + Math.min(OptimalGame(arr, i + 1, j - 1), OptimalGame(arr, i, j - 2)));
			return fn;
		}
	}

	public static int BUOptimalGame(int arr[]) {
		int n = arr.length;
		int dp[][] = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			dp[i][i] = arr[i];
		}
		for (int i = 0; i < arr.length - 1; i++) {
			dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
		}
		for (int i = 2; i < arr.length; i++) {
			int p = 0;

			for (int j = i; j < arr.length; j++) {
				if (i % 2 == 0) {
					dp[p][j] = Math.max(arr[j + 1] + Math.min(dp[p][j - 1], dp[p + 1][j]),
							arr[p] + Math.min(dp[p + 1][j], dp[p + 2][j + 1]));
					p++;
				} else {
					dp[p][j] = Math.max(dp[p][j - 1], dp[p + 1][j]);
					p++;
				}

			}
		}
		return dp[0][n];

	}

}
