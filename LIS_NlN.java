package LIS;

public class LIS_NlN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
		System.out.println(Lis(arr));

	}

	public static int Lis(int[] arr) {
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		int len = 1;
		for (int i = 1; i < arr.length; i++) {
			if (dp[len - 1] < arr[i]) {
				dp[len] = arr[i];
				len++;
			} else {
				int ans = BinarySearch(dp, len, arr[i]);
				

				if (ans < 0) {
					ans += 1;

				}
				dp[ans] = arr[i];
			}

		}
		for (int i = 0; i < len; i++) {
			System.out.print(dp[i]+" ");
		}
		return len;
	}

	public static int BinarySearch(int dp[], int len, int item) {
		int lo = 0;
		int hi = len - 1;
		int ans = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (dp[mid] >= item) {
				ans = mid;
				hi = hi- 1;
			} else {
				lo = mid + 1;
			}

		}
		return ans;
	}

}
