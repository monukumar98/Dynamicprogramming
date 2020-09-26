package Dynamicprogramming;

import java.util.*;

public class Min__cuts_Palindrome_Partitioning {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String X = sc.next();
			int ans[][] = new int[1100][1100];
			// System.out.println(minPalinPartition(X, 0, X.length() - 1, ans));
			// System.out.println(minPalPartion(X));
			//System.out.println(minPalinPartitionBU(X));
		}
	}

	public static boolean isPalindrome(String X, int i, int j) {
		while (i <= j) {
			if (X.charAt(i++) != X.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public static int minPalinPartition(String X, int i, int j, int[][] ans) {
		// base case: if starting index i and ending index j are equal
		// or X[i..j] is already a palindrome.

		if (i == j || isPalindrome(X, i, j)) {
			return 0;
		}
		if (ans[i][j] != 0) {
			return ans[i][j];
		}

		// stores minimum number cuts needed to partition X[i..j]
		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int count = 1 + minPalinPartition(X, i, k, ans) + minPalinPartition(X, k + 1, j, ans);

			if (count < min) {
				min = count;
				ans[i][j] = min;
			}
		}

		return min;
	}

	
}
