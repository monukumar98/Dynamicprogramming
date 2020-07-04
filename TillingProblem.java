package Dynamicprogramming;

import java.util.*;

public class TillingProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == m) {
				System.out.println(2);
			} else if (n < m) {
				System.out.println(1);
			} else {
				System.out.println(Tilling_Problem(n, m));
			}
		}

	}

	public static int Tilling_Problem(int n, int m) {
		if (n == m) {
			return 2;
		}
		if (n < 0 || m < 0) {
			return 0;
		}
		if (n < m) {
			return 1;
		}

		int ans = 0;
		if (n > m) {
			ans = (ans + Tilling_Problem(n - 1, m) % (n * m) + Tilling_Problem(n - m, m) % (n * m)) % (n * m);
		}
		return ans;

	}

}
