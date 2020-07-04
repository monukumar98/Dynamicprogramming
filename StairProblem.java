package Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class StairProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		// System.out.println(steps(n, k));
		System.out.println(TDsteps(n, k, new int[n + 1]));
		System.out.println(BUsteps(n, k));
		System.out.println(BUstepsT(n, k));

	}

	public static int steps(int n, int k) {
		if (n == 0) {
			// System.out.println(ans1);
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= k; i++) {
			if (n >= i) {
				ans = ans + steps(n - i, k);
			}
		}
		return ans;
	}

	public static int TDsteps(int n, int k, int dp[]) {
		if (n == 0) {

			return 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int ans = 0;
		for (int i = 1; i <= k; i++) {
			if (n >= i) {
				ans = ans + TDsteps(n - i, k, dp);
			}
		}
		return dp[n] = ans;
	}

// O(N*k)
	public static int BUsteps(int n, int k) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i >= j)
					dp[i] += dp[i - j];
			}

		}
		System.out.println(Arrays.toString(dp));

		return dp[n];
	}

	// O(n+k)
	public static int BUstepsT(int n, int k) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= k; i++) {

			dp[i] = 2 * dp[i - 1];
		}
		System.out.println(dp[k]);

		for (int i = k + 1; i <= n; i++) {

			dp[i] = 2 * dp[i - 1] - dp[i - k - 1];

		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
