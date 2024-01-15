package medium;

import java.util.Stack;

public class MaximumLengthOfSemiDecreasingSubarrays {
	
	public static void main(String[] args) {
		int res = maxSubarrayLength(new int[]{7, 6, 5, 4, 3, 2, 1, 6, 10, 11});
		System.out.println(res);
	}
	
	public static int maxSubarrayLength(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty() || nums[i] > nums[stack.peek()]) {
				stack.push(i);
			}
		}
		int res = 0;
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				res = Math.max(res, i - stack.pop() + 1);
			}
		}
		return res;
	}
	
}
