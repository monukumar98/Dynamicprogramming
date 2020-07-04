package Dynamicprogramming;

import java.util.*;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();

			}
			int dp[] = new int[arr.length];
			System.out.println(lisr(arr, Integer.MIN_VALUE, 0, dp));

			// Arrays.fill(dp, -1);
			// System.out.println(TDlisr(arr, Integer.MIN_VALUE, 0, dp));
			// System.out.println(Arrays.toString(dp));
			System.out.println(lisrBU(arr));
		}
	}

	public static int lisr(int[] arr, int prev, int i, int[] dp) {
		// TODO Auto-generated method stub
		if (i == arr.length) {
			return 0;
		}
		int ans = 0;
		if (arr[i] >= prev) {
			ans = 1 + lisr(arr, arr[i], i + 1, dp);
		}
		int noCon = lisr(arr, prev, i + 1, dp);
		return Math.max(ans, noCon);

	}

	public static int TDlisr(int[] arr, int prev, int i, int dp[]) {
		// TODO Auto-generated method stub
		if (i == arr.length) {
			return 0;
		}
//		
//		if (dp[i]!=-1) {
//			return dp[i];
//		}
		int ans = 0;
		if (arr[i] >= prev) {
			ans = 1 + TDlisr(arr, arr[i], i + 1, dp);
			ans += TDlisr(arr, prev, i + 1, dp);
		}
		int noCon = TDlisr(arr, prev, i + 1, dp);

		return dp[i] = Math.max(ans, noCon);
		// return Math.max(ans, noCon);

	}

	public static int lisrBU(int[] arr) {
		// TODO Auto-generated method stub
		int dp[] = new int[arr.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < arr.length; i++) {
			int ans = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] >= arr[j])
					ans = Math.max(dp[j], ans);
			}
			dp[i] = ans + 1;
		}
		Arrays.sort(dp);
		return dp[dp.length - 1];

	}

}
