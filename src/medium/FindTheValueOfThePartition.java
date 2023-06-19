package medium;

import java.util.Arrays;

public class FindTheValueOfThePartition {
	
	public static void main(String[] args) {
		int res = findValueOfPartition(new int[]{1, 3, 2, 4});
		System.out.println(res);
	}
	
	public static int findValueOfPartition(int[] nums) {
		Arrays.sort(nums);
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			res = Math.min(res, nums[i] - nums[i - 1]);
		}
		return res;
	}
	
}
