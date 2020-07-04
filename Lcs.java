package Dynamicprogramming;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Lcs {
	static int[][] strg = new int[1000 + 5][1000 + 5];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str1 = sc.next();

		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}

	//	System.out.println(lcs(str, str1, strg));
		System.out.println(lcsDP(str, str1));

	}

	public static int lcs(String str, String str1, int strg[][]) {
		if (str.length() == 0 || str1.length() == 0) {
			return 0;
		}
		char ch1 = str.charAt(0);
		char ch2 = str1.charAt(0);
		if (strg[str.length()][str1.length()] != -1) {
			return strg[str.length()][str1.length()];
		}
		int ans = 0;
		if (ch1 == ch2) {
			ans += lcs(str.substring(1), str1.substring(1), strg) + 1;
		} else {
			ans += Math.max(lcs(str, str1.substring(1), strg), lcs(str.substring(1), str1, strg));
		}
		return strg[str.length()][str1.length()] = ans;
	}

	public static int lcsDP(String s1, String s2) {
		// TODO Auto-generated method stub
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}

		}
		return dp[s1.length()][s2.length()];

	}

}