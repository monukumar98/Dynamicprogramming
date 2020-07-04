package Dynamicprogramming;

import java.util.Scanner;

public class MinimumSteps {
// MiNi n----->1
// N = N/3 if(N%3==0) and N = N/2 if( N%2)  N=N-1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(minimuanswer(n));
	//	System.out.println(minimuanswerBU(n));
	}

	public static int minimuanswer(int n) {
		if (n == 1) {
			return 0;
		}
		int op1 = Integer.MAX_VALUE;
		int op2 = Integer.MAX_VALUE;

		int op3 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			op1 = minimuanswer(n / 3);
		}
		if (n % 2 == 0) {
			op2 = minimuanswer(n / 2);
		}

		op3 = minimuanswer(n - 1);
		return Math.min(op2, Math.min(op1, op3)) + 1;

	}

	public static int minimuanswerBU(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int op1 = Integer.MAX_VALUE;
			int op2 = Integer.MAX_VALUE;

			int op3 = Integer.MAX_VALUE;
			if (i % 2 == 0) {
				op1 = dp[i / 2];

			}
			if (i % 3 == 0) {
				op2 = dp[i / 3];
			}
			op3 = dp[i - 1];
			dp[i] = Math.min(op2, Math.min(op1, op3)) + 1;

		}
		return dp[n-1];
	}

}
