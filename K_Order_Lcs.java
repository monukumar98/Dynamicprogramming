package Dynamicprogramming;

import java.util.Scanner;

public class K_Order_Lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		long arr1[] = new long[n];
		long arr2[] = new long[m];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextLong();
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextLong();
		}
		// System.out.println(KOrdeLcs(arr1, arr2, 0, 0, k));
		 System.out.println(KOrdeLcsTD(arr1, arr2, 0, 0, k, new long[n + 1][m + 1][k +
		 1]));
		//System.out.println(KOrdeLcsBU(arr1, arr2, k));

	}

	public static long KOrdeLcs(long[] arr1, long[] arr2, int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i == arr1.length || j == arr2.length) {
			return 0;
		}

		long ans = 0;

		if (arr1[i] == arr2[j]) {
			ans = 1 + KOrdeLcs(arr1, arr2, i + 1, j + 1, k);
		} else {
			if (k > 0) {
				ans = Math.max(ans, 1 + KOrdeLcs(arr1, arr2, i + 1, j + 1, k - 1));
			}
			ans = Math.max(KOrdeLcs(arr1, arr2, i + 1, j, k), ans);
			ans = Math.max(KOrdeLcs(arr1, arr2, i, j + 1, k), ans);
		}
		return ans;
	}

	public static long KOrdeLcsTD(long[] arr1, long[] arr2, int i, int j, int k, long dp[][][]) {
		// TODO Auto-generated method stub
		if (i == arr1.length || j == arr2.length) {
			return 0;
		}
		if (dp[i][j][k] != 0) {
			return dp[i][j][k];
		}

		long ans = 0;

		if (arr1[i] == arr2[j]) {
			ans = 1 + KOrdeLcsTD(arr1, arr2, i + 1, j + 1, k, dp);
		} else {
			if (k > 0)
				ans = Math.max(ans, 1 + KOrdeLcsTD(arr1, arr2, i + 1, j + 1, k - 1, dp));
			ans = Math.max(KOrdeLcsTD(arr1, arr2, i + 1, j, k, dp), ans);
			ans = Math.max(KOrdeLcsTD(arr1, arr2, i, j + 1, k, dp), ans);
		}
		return dp[i][j][k] = ans;
	}

	public static long KOrdeLcsBU(long[] arr1, long[] arr2, int k) {
		long dp[][][] = new long[arr1.length + 1][arr2.length + 1][k + 1];
		for (int i = 1; i <= arr1.length; i++) {
			for (int j = 1; j <= arr2.length; j++) {
				for (int l = 1; l <= k; l++) {
					if (arr1[i - 1] == arr2[j - 1]) {
						dp[i][j][l] = dp[i - 1][j - 1][l] + 1;
					} else {
						dp[i][j][l] = Math.max(dp[i - 1][j - 1][l - 1] + 1, Math.max(dp[i - 1][j][l], dp[i][j - 1][l]));
					}
				}
			}
		}
		return dp[arr1.length][arr2.length][k];
	}

}
