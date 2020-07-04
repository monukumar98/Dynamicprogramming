package Dynamicprogramming;

public class MCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int arr[] = { 4,10, 3, 12, 20,7 };
		System.out.println(MCM(arr, 0, arr.length - 1));
		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MCMBU(arr));
	}

	public static int MCM(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		if (si + 1 == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = si + 1; i < ei; i++) {
			int fh = MCM(arr, si, i);
			int sh = MCM(arr, i, ei);
			int sa = arr[si] * arr[i] * arr[ei];
			int total = fh + sh + sa;
			min = Math.min(total, min);

		}
		return min;
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] dp) {
		// TODO Auto-generated method stub
		if (si + 1 == ei) {
			return 0;
		}
		if (dp[si][ei] != 0) {
			return dp[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int i = si + 1; i < ei; i++) {
			int fh = MCMTD(arr, si, i, dp);
			int sh = MCMTD(arr, i, ei, dp);
			int sa = arr[si] * arr[i] * arr[ei];
			int total = fh + sh + sa;
			min = Math.min(total, min);

		}
		return dp[si][ei] = min;
	}

	public static int MCMBU(int[] arr) {
		int dp[][] = new int[arr.length][arr.length];
		for (int slide = 1; slide <= arr.length - 2; slide++) {

			for (int si = 0; si <= arr.length - slide - 2; si++) {

				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fh = dp[si][k];
					int sh = dp[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];

					int total = fh + sh + sw;

					if (total < min) {
						min = total;
					}

				}

				dp[si][ei] = min;

			}

		}

		return dp[0][arr.length - 1];
	}
}
