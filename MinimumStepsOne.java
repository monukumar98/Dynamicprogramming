package Dynamicprogramming;

import java.util.Scanner;

public class MinimumStepsOne {
// f(n) = min(f(n/3),f(n/2),f(n-1))(if(n%3==0->f(n/3)and if(n%2==0)-->f(n/2)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(miniSteps(n));
		System.out.println(TDminiSteps(n, new int[n + 5]));
		System.out.println(BUminiSteps(n));

	}

	public static int miniSteps(int n) {
		if (n == 1) {
			return 0;
		}
		int n3 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE, n1 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			n3 = miniSteps(n / 3);
		}
		if (n % 2 == 0) {
			n2 = miniSteps(n / 2);
		}
		n1 = miniSteps(n - 1);
		return Math.min(n1, Math.min(n2, n3)) + 1;

	}

	public static int TDminiSteps(int n, int dp[]) {
		if (n == 1) {
			return 0;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int n3 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE, n1 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			n3 = miniSteps(n / 3);
		}
		if (n % 2 == 0) {
			n2 = miniSteps(n / 2);
		}
		n1 = miniSteps(n - 1);
		return dp[n] = Math.min(n1, Math.min(n2, n3)) + 1;

	}

	public static int BUminiSteps(int n) {
		if (n == 1) {
			return 0;
		}
		int dp[] = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			int n3 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE, n1 = Integer.MAX_VALUE;
			if (i % 2 == 0) {
				n2 = dp[i/2];
			}
			if (i % 3 == 0) {
				n3 = dp[i/ 3];
			}
			n1 = dp[i - 1];
			dp[i] = Math.min(n1, Math.min(n2, n3)) + 1;

		}
		return dp[n];

	}

}
