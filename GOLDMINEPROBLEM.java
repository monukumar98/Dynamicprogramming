package Dynamicprogramming;

import java.util.*;
public class GOLDMINEPROBLEM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(Gold(arr, 0, 0));
		}

	}

	public static int Gold(int arr[][], int cc, int cr) {
		if (cc >= arr[0].length || cr < 0 || cr >= arr.length) {
			return 0;
		}
		int l1, l2, l3;
		l1 = Gold(arr, cc + 1, cr);
		l2 = Gold(arr, cc + 1, cr + 1);
		l3 = Gold(arr, cc + 1, cr - 1);
		return arr[cr][cc] + Math.max(l1,Math.max(l2, l3));


	}

}
