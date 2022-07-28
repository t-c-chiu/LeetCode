package easy;

import java.util.Arrays;

public class FindPivotIndex {
	
	public static void main(String[] args) {
	
	}
	
	public static int pivotIndex(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		int curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (curSum * 2 + nums[i] == sum) {
				return i;
			}
			curSum += nums[i];
		}
		return -1;
	}
}
