package medium;

import java.util.Arrays;

public class DeleteAndEarn {
	
	public static void main(String[] args) {
		int res = deleteAndEarn(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 5, 7});
		System.out.println(res);
	}
	
	/**
	 * 2 2 3 3 3 4
	 * 4 9 4
	 * <p>
	 * 1 1 1 2 2 3 4 4 5 7
	 * 3 4 3 8 5 0 7
	 */
	public static int deleteAndEarn(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		
		Arrays.sort(nums);
		int n = nums.length;
		int min = nums[0];
		int max = nums[n - 1];
		int[] sum = new int[max - min + 1];
		for (int i = 0; i < n; i++) {
			sum[nums[i] - min] += nums[i];
		}
		
		int prev = sum[0];
		int res = Math.max(sum[0], sum[1]);
		for (int i = 2; i < sum.length; i++) {
			int tmp = res;
			res = Math.max(res, prev + sum[i]);
			prev = tmp;
		}
		return res;
	}
}
