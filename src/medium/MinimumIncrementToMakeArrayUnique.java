package medium;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
	
	public static void main(String[] args) {
		int res = minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7});
		System.out.println(res);
	}
	
	public static int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int res = 0, next = 0;
		for (int num : nums) {
			res += Math.max(next - num, 0);
			next = Math.max(num, next) + 1;
		}
		return res;
	}

//	public static int minIncrementForUnique(int[] nums) {
//		Arrays.sort(nums);
//		int res = 0;
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] <= nums[i - 1]) {
//				int newNum = nums[i - 1] + 1;
//				res += newNum - nums[i];
//				nums[i] = newNum;
//			}
//		}
//		return res;
//	}
}
