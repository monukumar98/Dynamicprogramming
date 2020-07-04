package Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class ValentineDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nob = sc.nextInt();
		int nog = sc.nextInt();
		int boy[] = new int[nob];
		int girl[] = new int[nog];
		for (int i = 0; i < nob; i++) {
			boy[i] = sc.nextInt();
		}
		for (int i = 0; i < nog; i++) {
			girl[i] = sc.nextInt();
		}
		int dp[][] = new int[5005][5005];
		for (int i = 0; i < 5005; i++) {
			for (int j = 0; j < 5005; j++) {
				dp[i][j] = -1;
			}
		}
		Arrays.sort(boy);
		Arrays.sort(girl);
		System.out.println(valentinemagic(boy, girl, 0, 0, dp));

	}

	public static int valentinemagic(int[] boy, int girl[], int i, int j, int[][] dp) {
		if (i == boy.length) {
			return 0;
		}
		if (j == girl.length) {
			return 1_000_000_000;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int fn = Math.abs(boy[i] - girl[j]) + valentinemagic(boy, girl, i + 1, j + 1, dp);
		// System.out.println("fn " + fn);
		int fn2 = valentinemagic(boy, girl, i, j + 1, dp);
		// System.out.println("fn2 " + fn2);
		return dp[i][j] = Math.min(fn, fn2);

	}

}
