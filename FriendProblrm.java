package Dynamicprogramming;

import java.util.Scanner;

public class FriendProblrm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(no_of_way(n));
			System.out.println(TDno_of_way(n, new int[n + 1]));
			System.out.println(BUno_of_way(n));
		}

	}

	public static int no_of_way(int n) {
		if (n <= 2) {
			return n;
		}
		int fn = no_of_way(n - 1) + (n - 1) * no_of_way(n - 2);
		return fn;
	}

	public static int TDno_of_way(int n, int dp[]) {
		if (n <= 2) {
			return n;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int fn = no_of_way(n - 1) + (n - 1) * no_of_way(n - 2);
		return dp[n] = fn;
	}

	public static int BUno_of_way(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (i - 1) * dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}

}
