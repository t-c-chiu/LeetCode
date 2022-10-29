package medium;

import java.util.Arrays;

public class FindTheOriginalArrayOfPrefixXor {
	
	public static void main(String[] args) {
		int[] res = findArray(new int[]{5, 2, 0, 3, 1});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] findArray(int[] pref) {
		int n = pref.length, xor = 0;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = pref[i] ^ xor;
			xor ^= res[i];
		}
		return res;
	}
}
