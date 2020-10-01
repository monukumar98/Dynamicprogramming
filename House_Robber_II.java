package Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class House_Robber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}
		System.out.println(Math.max(House_Robber_I(arr, 0, arr.length - 2), House_Robber_I(arr, 1, arr.length - 1)));
		int dp[] = new int[arr.length];
		if (arr.length == 1) {
			System.out.println(arr[0]);
			return;
		}
		if (arr.length == 2) {
			System.out.println(Math.max(arr[0], arr[1]));
			return;
		}
		Arrays.fill(dp, -1);

		int ans1 = House_Robber_ITOP(arr, dp, 0, arr.length - 2);
		Arrays.fill(dp, -1);
		int ans2 = House_Robber_ITOP(arr, dp, 1, arr.length - 1);
		System.out.println(Math.max(ans1, ans2));
	}

	public static int House_Robber_I(int[] arr, int si, int ei) {
		if (arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		if (arr.length == 2) {
			return Math.max(arr[0], arr[1]);
		}
		int dp[] = new int[arr.length];
		dp[si] = arr[si];
		dp[si + 1] = Math.max(arr[si], arr[si + 1]);
		for (int i = si + 2; i <= ei; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);

		}
		return dp[ei];
	}

	public static int House_Robber_ITOP(int[] arr, int[] dp, int i, int ei) {
		if (arr.length == 0) {
			return 0;
		}
		if (i > ei) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}

		return dp[i] = Math.max(arr[i] + House_Robber_ITOP(arr, dp, i + 2, ei), House_Robber_ITOP(arr, dp, i + 1, ei));

	}

}
