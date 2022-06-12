package medium;

import java.util.Stack;

public class MaximumWidthRamp {
	
	public static void main(String[] args) {
		int res = maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1});
		System.out.println(res);
	}
	
	public static int maxWidthRamp(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < n; i++) {
			while (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
				stack.push(i);
			}
		}
		for (int i = n - 1; i >= 0 && !stack.isEmpty(); i--) {
			while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
				res = Math.max(res, i - stack.pop());
			}
		}
		return res;
	}
}
