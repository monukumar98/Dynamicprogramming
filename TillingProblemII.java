package Dynamicprogramming;

import java.util.Scanner;

public class TillingProblemII {
	static int mod = (int) (1e9 + 7);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
//			System.out.println(mod);
//			System.out.println(TillProblem(n, m));
//			System.out.println(TillProblemTD(n, m, new long[n + 1]));
			System.out.println(TillProblemBU(n, m));

		}
	}

	public static long TillProblem(int n, int m) {
		if (n == m) {
			return 2;
		}
		if (n < m) {
			return 1;
		}
		if (n <= 0) {
			return 0;
		}
		long ans = 0;
		ans = (ans + TillProblem(n - 1, m)) % mod;
		if (n - m >= 0) {
			ans = (ans + TillProblem(n - m, m)) % mod;
		}
		return ans;
	}

	public static long TillProblemTD(int n, int m, long dp[]) {

		if (n == m) {
			return 2;
		}
		if (n < m) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (dp[n] != 0) {
			return dp[n];
		}

		long ans = 0;
		ans = (ans + TillProblemTD(n - 1, m, dp)) % mod;
		if (n - m >= 0) {
			ans = (ans + TillProblemTD(n - m, m, dp)) % mod;
		}
		return ans % mod;
	}

	public static long TillProblemBU(int n, int m) {

		long dp[] = new long[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1]%mod;
			if (i - m >= 0) {
				dp[i] = (dp[i] + dp[i - m]%mod)%mod;
			}
		}
		return dp[n]%mod;
	}
}
