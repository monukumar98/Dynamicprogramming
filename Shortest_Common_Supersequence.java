package Dynamicprogramming;

import java.util.Scanner;

public class Shortest_Common_Supersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str1 = sc.next();
		System.out.println(Common_Supersequence(str, str1));

	}

	public static String Common_Supersequence(String str1, String str2) {
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
				str = str1.charAt(i-1) + str;
				i--;j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					str = str2.charAt(j - 1) + str;
					j--;
				} else {
					str = str1.charAt(i - 1) + str;
					i--;
				}
			}

		}
		while (i > 0) {
			str = str1.charAt(i - 1) + str;
			i--;
		}
		while (j > 0) {
			str = str2.charAt(j - 1) + str;
			j--;
		}
		return str;
	}

}
