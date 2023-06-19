package easy;

import java.util.Arrays;

public class NeitherMinimumNorMaximum {
	
	public int findNonMinOrMax(int[] nums) {
		int n = nums.length;
		if (n <= 2) {
			return -1;
		}
		Arrays.sort(nums);
		return nums[1];
	}
}
