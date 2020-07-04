package Dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumLengthBitonicSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(BitonicSubsequnce(arr));

		}

	}

	public static int BitonicSubsequnce(int arr[]) {
		int Is[] = new int[arr.length];
		int Ds[] = new int[arr.length];
		Arrays.fill(Is, 1);
		Arrays.fill(Ds, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && Is[i] < Is[j] + 1) {
					Is[i] = Is[j ]+1;
				}
			}

		}
		for (int j = arr.length - 2; j >= 0; j--) {
			for (int i = arr.length - 1; i > j; i--) {
				if (arr[i] < arr[j] && Ds[j] < Ds[i] + 1) {
					Ds[j] = Ds[i] + 1;
				}
			}
		}
		int max = Is[0] + Ds[0] - 1;
		for (int i = 1; i < arr.length; i++) {
			if (max < Is[i] + Ds[i] - 1) {
				max = Is[i] + Ds[i] - 1;
			}
		}
		return max;
	}

}
