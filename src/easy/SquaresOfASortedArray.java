package easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
		System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
	}
	
	public static int[] sortedSquares(int[] nums) {
		int n = nums.length, left = 0, right = n - 1, i = n - 1;
		int[] res = new int[n];
		while (left <= right) {
			if (Math.abs(nums[left]) < Math.abs(nums[right])) {
				res[i--] = nums[right] * nums[right];
				right--;
			} else {
				res[i--] = nums[left] * nums[left];
				left++;
			}
		}
		return res;
	}
}
