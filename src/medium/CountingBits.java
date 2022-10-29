package medium;

import java.util.Arrays;

public class CountingBits {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(2)));
		System.out.println(Arrays.toString(countBits(7)));
	}
	
	public static int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			res[i] = i % 2 == 0 ? res[i / 2] : res[i - 1] + 1;
		}
		return res;
	}
}
