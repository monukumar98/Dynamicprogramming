package Dynamicprogramming;

import java.util.HashMap;
import java.util.Scanner;

public class TheSubsetSumToTarget {
	static HashMap<Integer, Boolean> map = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		if (istargetsum(arr, target, 0, 0)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean istargetsum(int arr[], int target, int sum, int i) {
		if (sum == target) {
			return true;
		}
		if (i == arr.length) {
			return false;
		}
		if(map.containsKey(sum)) {
			return map.get(sum);
		}
		boolean ca = istargetsum(arr, target, sum + arr[i], i + 1);
		boolean na = istargetsum(arr, target, sum, i + 1);
		 map.put(sum,ca || na);
		 return map.get(sum);
	}

}
