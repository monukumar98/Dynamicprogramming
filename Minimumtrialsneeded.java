package Dynamicprogramming;

import java.util.Scanner;

public class Minimumtrialsneeded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int k = sc.nextInt();
			int f = sc.nextInt();
			System.out.println(Minimum_trials_needed_Plate_Dropping(k, f));
			System.out.println(TDMinimum_trials_needed_Plate_Dropping(k, f, new int[k + 1][f + 1]));
			System.out.println(BUMinimum_trials_needed_Plate_Dropping(k, f));
		}

	}

	public static int Minimum_trials_needed_Plate_Dropping(int k, int f) {
		if (f == 0 || f == 1) {
			return f;
		}
		if (k == 1) {
			return f;
		}
		int ans = Integer.MAX_VALUE;
		for (int e = 1; e <= f; e++) {
			int tem = 1 + Math.max(Minimum_trials_needed_Plate_Dropping(k - 1, e - 1),
					Minimum_trials_needed_Plate_Dropping(k, f - e));
			ans = Math.min(tem, ans);
		}
		return ans;

	}

	public static int TDMinimum_trials_needed_Plate_Dropping(int k, int f, int dp[][]) {
		if (f == 0 || f == 1) {
			return f;
		}
		if (k == 1) {
			return f;
		}
		if (dp[k][f] != 0) {
			return dp[k][f];
		}
		int ans = Integer.MAX_VALUE;
		for (int e = 1; e <= f; e++) {
			int tem = 1 + Math.max(TDMinimum_trials_needed_Plate_Dropping(k - 1, e - 1, dp),
					TDMinimum_trials_needed_Plate_Dropping(k, f - e, dp));
			ans = Math.min(tem, ans);
		}
		return dp[k][f] = ans;

	}

	public static int BUMinimum_trials_needed_Plate_Dropping(int k, int f) {
		int dp[][] = new int[k + 1][f + 1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
			
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][1] = 1;
		}
		for (int i = 2; i < dp.length; i++) {
			for (int j = 2; j < dp[0].length; j++) {
				if (i > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
				for (int j2 = 1; j2 <= j; j2++) {
					dp[i][j] = Integer.MAX_VALUE;
					int re = Math.max(dp[i - 1][j2 - 1], dp[i][j - j2]);
					dp[i][j] = Math.min(re, dp[i][j]);
				}
				dp[i][j] = dp[i][j] + 1;
				}

			}
		}
		return dp[k][f];

	}

}
