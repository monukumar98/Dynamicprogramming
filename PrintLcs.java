package Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class PrintLcs {
	static int[][] dp = new int[1009][10009];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str1 = sc.next();

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		int len = lcs(str, str1);
		System.out.println();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str1.length(); j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(printString(str, str1, len));
		System.out.println(len);
	}

	public static int lcs(String str, String str1) {
		if (str.length() == 0 || str1.length() == 0) {
			return 0;
		}
		char ch1 = str.charAt(0);
		char ch2 = str1.charAt(0);
		if (dp[str.length()][str1.length()] != -1) {
			return dp[str.length()-1][str1.length()-1];
		}
		int ans = 0;
		if (ch1 == ch2) {
			ans += lcs(str.substring(1), str1.substring(1)) + 1;
		} else {
			ans += Math.max(lcs(str, str1.substring(1)), lcs(str.substring(1), str1));
		}
		return dp[str.length()-1][str1.length()-1] = ans;
	}

	public static String printString(String s1, String s2, int len) {
		String str = "";
		int i = s1.length(), j = s2.length();
		while ( i >0  && j >0) {
			if (s1.charAt(i) == s2.charAt(j)) {

				str = s1.charAt(i) + str;
				i--;
				j--;
				len--;
			} else {
				if (dp[i-1][j] >= dp[i][j-1]) {
					i--;
				} else {
					j--;
				}
			}
			System.out.println(i + " " + j + " " + len + " " + str);
		}
		return str;

	}

}