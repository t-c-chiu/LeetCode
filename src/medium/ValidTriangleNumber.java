package medium;

import java.util.Arrays;

public class ValidTriangleNumber {
	
	public static void main(String[] args) {
		int res = triangleNumber(new int[]{2, 3, 4, 4});
		System.out.println(res);
	}
	
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 2; i < nums.length; i++) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum > nums[i]) {
					res += right - left;
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}
}
