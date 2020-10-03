package Dynamicprogramming;

import java.util.*;

public class Lis_Sum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int Arr[] = new int[n];
			for (int i = 0; i < n; i++)
				Arr[i] = sc.nextInt();

			System.out.println(maxSumIS(Arr, n));
		}
	}

	public static int maxSumIS(int arr[], int n) {
		// code here.
		int dp[] = new int[arr.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = arr[i];
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}

			}

		}
		Arrays.sort(dp);
		return dp[dp.length - 1];
	}
}