package easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {
	
	public static void main(String[] args) {
		int res = largestPerimeter(new int[]{3,2,3,4});
		System.out.println(res);
	}
	
	public static int largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 2; i--) {
			if (nums[i - 2] + nums[i - 1] > nums[i]) {
				return nums[i - 2] + nums[i - 1] + nums[i];
			}
		}
		return 0;
	}
}
