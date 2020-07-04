package Dynamicprogramming;

import java.util.*;

public class Wildcard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String pattern = sc.next();
		int dp[][] = new int[str.length() + 5][pattern.length() + 5];
		if (WildcardProblem(str, pattern, dp)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static boolean WildcardProblem(String str, String pattern, int[][] dp) {
		// positive base case
		if (str.length() == 0 && pattern.length() == 0) {
			return true;
		}
		// negative base case
		if (str.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		// negative base case
		if (str.length() != 0 && pattern.length() == 0) {
			return false;
		}
		// self work
		char str_ch = str.charAt(0);
		char pattern_ch = pattern.charAt(0);
		String Str_ros = str.substring(1);
		String pattern_ros = pattern.substring(1);
		if (dp[str.length()][pattern.length()] != 0) {
			if (dp[str.length()][pattern.length()] == 1) {
				return false;
			} else
				return true;
		}
		boolean ans;
		if (str_ch == pattern_ch || pattern_ch == '?') {
			ans = WildcardProblem(Str_ros, pattern_ros, dp);
		} else if (pattern_ch == '*') {
			ans = WildcardProblem(Str_ros, pattern, dp) || WildcardProblem(str, pattern_ros, dp);
		} else {
			ans = false;
		}

		if (ans) {
			dp[str.length()][pattern.length()] = 2;
		} else {
			dp[str.length()][pattern.length()] = 1;
		}
		return ans;
	}
}