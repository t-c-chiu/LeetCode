package medium;

import java.util.Arrays;

public class ThreeSumSmaller {
	
	public static void main(String[] args) {
		int res = threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
		System.out.println(res);
	}
	
	public static int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] < target) {
					res += right - left;
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
	
}
