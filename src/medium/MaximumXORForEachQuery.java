package medium;

import java.util.Arrays;

public class MaximumXORForEachQuery {
	
	public static void main(String[] args) {
		int[] res = getMaximumXor(new int[]{2, 3, 4, 7}, 3);
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] getMaximumXor(int[] nums, int maximumBit) {
		int xor = 0, max = (1 << maximumBit) - 1, n = nums.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			xor ^= nums[i];
			res[n - i - 1] = xor ^ max;
		}
		return res;
	}
}
