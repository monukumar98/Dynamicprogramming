package Dynamicprogramming;

import java.util.Scanner;

public class Lcs3 {
	static int dp[][][] = new int[200][200][200];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();
		for (int i = 0; i < 200; i++) {
			for (int j = 0; j < 200; j++) {
				for (int k = 0; k < 200; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		System.out.println(printLcs3(str1, str2, str3));
	}

	public static int printLcs3(String str1, String str2, String str3) {
		if (str1.length() == 0 || str2.length() == 0 || str3.length() == 0) {
			return 0;

		}
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);
		char ch3 = str3.charAt(0);
		if (dp[str1.length()][str2.length()][str3.length()] != -1) {

			return dp[str1.length()][str2.length()][str3.length()];
		}
		if (ch1 == ch2 && ch2 == ch3) {
			return dp[str1.length()][str2.length()][str3.length()] = 1+printLcs3(str1.substring(1), str2.substring(1),
					str3.substring(1));
		}
		if (ch1 == ch2 && ch1 != ch3) {
			return dp[str1.length()][str2.length()][str3.length()] = Math.max(
					printLcs3(str1.substring(1), str2.substring(1), str3), printLcs3(str1, str2, str3.substring(1)));
		}
		if (ch1 == ch3 && ch1 != ch2) {
			return dp[str1.length()][str2.length()][str3.length()] = Math.max(
					printLcs3(str1.substring(1), str2, str3.substring(1)), printLcs3(str1, str2.substring(1), str3));
		}
		if (ch2 == ch3 && ch2 != ch1) {
			return dp[str1.length()][str2.length()][str3.length()] = Math.max(
					printLcs3(str1, str2.substring(1), str3.substring(1)), printLcs3(str1.substring(1), str2, str3));
		}
		return dp[str1.length()][str2.length()][str3.length()] = Math.max(
				(Math.max(printLcs3(str1.substring(1), str2, str3), printLcs3(str1, str2.substring(1), str3))),
				printLcs3(str1, str2, str3.substring(1)));

	}
}
