package Dynamicprogramming;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int wt[] = new int[n];
		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}
		int val[] = new int[n];
		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}
	//	System.out.println(knapSack(w, wt, val, n));
		int arr[] [] = new int[1005][1005];
		System.out.println(knapSacTD(w, wt, val, n, arr));
	}

	public static int knapSack(int w, int[] wt, int[] val, int n) {
		if (w == 0 || n == 0) {
			return 0;
		}
		if (wt[n - 1] > w) {
			return knapSack(w, wt, val, n - 1);
		} else {
			return Math.max(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1), knapSack(w, wt, val, n - 1));
		}
	}

	public static int knapSacTD(int w, int[] wt, int[] val, int n,int arr[] []) {
		if (w == 0 || n == 0) {
			return 0;
		}
		if(arr[w][n]>0) {
			return arr[w][n];
		}
		if (wt[n - 1] > w) {
			return arr[w][n]=knapSacTD(w, wt, val, n - 1,arr);
		} else {
			return arr[w][n]=Math.max(val[n - 1] + knapSacTD(w-wt[n-1], wt, val, n - 1,arr), knapSacTD(w, wt, val, n - 1,arr));
		}
	}
	public static int knapSack(int W, int wt[], int val[], int n,int k[][]) {
		if (n == 0 || W == 0) {
			return 0;
		}
		if(k[n][W]!=0){
			return k[n][W];
		}
		int ans =0;
		if(wt[n-1]>W){
			ans = knapSack(W,wt,val,n-1,k);
		}
		else{
		ans =  Math.max(val[n-1]+ knapSack(W-wt[n-1],wt,val,n-1,k),knapSack(W,wt,val,n-1,k));
	}
	return k[n][W]=ans;
	}

}
