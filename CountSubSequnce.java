package Dynamicprogramming;

import java.util.*;

public class CountSubSequnce {
	static int mod = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			String str = sc.next();

			System.out.println(subseq(str, new HashMap<Character, Integer>()));
		}
	}

	public static int subseq(String str, HashMap<Character, Integer> map) {
		if (str.length() == 0) {
			return 1;
		}
		char ch = str.charAt(0);
		int ans = 0;
		int t = 0;
		ans += subseq(str.substring(1), map) % mod;
		if (!map.containsKey(ch))
			map.put(ch, ans % mod);
		else {
			t = map.get(ch) % mod;
			map.put(ch, ans);
		}
		ans = ((((ans * 2) % mod) - (t % mod)) % mod) + mod;
		return ans % mod;

	}

	public static int subseq2(String str, HashMap<Character, Integer> map) {

		if (str.length() == 0) {

			return 1;
		}

		char ch = str.charAt(0);

		int ans = 0;

		int k = subseq2(str.substring(1), map) % mod;

		ans = (ans + k) % mod;
		int l = ans;
		int t = map.getOrDefault(ch, 0);
		ans = ((((ans * 2) % mod) - t % mod) % mod) + mod;
		map.put(ch, l);

		return ans % mod;

	}

}
