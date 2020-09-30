package Dynamicprogramming;
import java.util.Arrays;
import java.util.Scanner;

public class Houserubber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

		}
		//System.out.println(rob(arr));
		int [] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(toprob(arr, dp, 0));
	}

	public static int rob(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		if (arr.length == 2) {
			return Math.max(arr[0], arr[1]);
		}
		if (arr.length == 1) {
			return arr[0];
		}

		int dp[] = new int[arr.length + 2];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);

		}
		return dp[arr.length - 1];
	}

	public static int toprob(int arr[], int dp[], int i) {
		if (arr.length == 0) {
			return 0;
		}
		if (i >= arr.length) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}

		return dp[i] = Math.max(arr[i] + toprob(arr, dp, i + 2), toprob(arr, dp, i + 1));

	}

}
