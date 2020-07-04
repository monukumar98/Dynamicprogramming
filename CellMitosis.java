package Dynamicprogramming;

import java.util.Scanner;

public class CellMitosis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		System.out.println(cell(n, x, y, z));

	}

	public static long cell(int n,int x,int y,int z) {
		long dp []= new long [n+1];
		for(int i=2; i<=n; i++) {
			if((i&1)==1) {
				dp[i]= Math.min(dp[((i+1)/2)]+x + z, dp[i-1]+y);
			}
			else {
				dp[i]= Math.min(dp[i/2]+x, dp[i-1]+y);
			}
		}
		return dp[n];
	}

}
