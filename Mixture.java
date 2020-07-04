package Dynamicprogramming;

import java.util.*;

public class Mixture {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int dp[][] = new int[101][101];
		System.out.println(harry(arr, 0, arr.length - 1, dp));

	}

	public static int harry(int[] arr, int si, int ei, int dp[][]) {
		if (si == ei) {
			return 0;

		}
		if (dp[si][ei] != 0) {
			return dp[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int i = si; i <= ei - 1; i++) {

			int fh = harry(arr, si, i, dp);
			int sh = harry(arr, i + 1, ei, dp);
			int sw = colour(arr, si, i) * colour(arr, i + 1, ei); // some smoke in the process.
			int total = sw + fh + sh;
			if (total < min) {
				min = total;
			}
		}
		return dp[si][ei] = min;
	}

	public static int colour(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}
		return sum % 100;
	}

	public static int harryBU(int[] arr) {
		int dp[][] = new int[arr.length][arr.length];
		for (int slide = 1; slide < arr.length; slide++) {
			for (int si = 0; si < arr.length - slide; si++) {
				int ei = si + slide;
				int min = Integer.MAX_VALUE;
				for (int k = si; k <= ei-1; k++) {
					int fh = dp[si][k];
					int sh = dp[k+1][ei];
					int sw = colour(arr, si,k)*colour(arr, k+1, ei);
					min = Math.min(fh+sh+sw, min);
				}					
				dp[si][ei]=min;

				
			}

		}
		return dp[0][dp.length-1];

	}

}
