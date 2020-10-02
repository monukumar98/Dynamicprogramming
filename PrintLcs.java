package Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class PrintLcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str1 = sc.next();
		int[][] dp = new int[str.length() + 1][str1.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 0);
		}

		int len = lcs(str, str1, dp);
		// System.out.println();
//		for (int i = 0; i <= str.length(); i++) {
//			for (int j = 0; j <= str1.length(); j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(printString(str, str1));
		// System.out.println(len);
	}

	public static int lcs(String str, String str1, int[][] dp) {
		if (str.length() == 0 || str1.length() == 0) {
			return 0;
		}

		if (dp[str.length()][str1.length()] != 0) {
			return dp[str.length()][str1.length()];
		}
		char ch1 = str.charAt(0);
		char ch2 = str1.charAt(0);
		int ans = 0;
		if (ch1 == ch2) {
			ans += lcs(str.substring(1), str1.substring(1), dp) + 1;
		} else {
			ans += Math.max(lcs(str, str1.substring(1), dp), lcs(str.substring(1), str1, dp));
		}
		return dp[str.length()][str1.length()] = ans;
	}

	public static String printString(String str1, String str2) {

		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}

		}

		int i = str1.length();
		int j = str2.length();
		String str = "";
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				str = str1.charAt(i - 1) + str;
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {

					j--;
				} else {

					i--;
				}
			}

		}

		return str;
	}

}