package Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int dp[] = new int[1005];
			Arrays.fill(dp, -1);
			System.out.println(minJumps(arr, 0, arr.length - 1, dp));

		}

	}

	public static int minJumps(int arr[], int si, int ei, int[] dp) {
		if (si == ei) {
			return 0;
		}
		if (arr[si] == 0) {
			return Integer.MAX_VALUE;
		}
		if (dp[si] != -1) {
			return dp[si];
		}
		int min = Integer.MAX_VALUE;
		for (int i = si + 1; i <= ei && i <= si + arr[si]; i++) {
			int jumps = minJumps(arr, i, ei, dp);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}
		return dp[si] = min;
	}

}
