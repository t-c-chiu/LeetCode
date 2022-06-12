package medium;

import java.util.Stack;

public class OneThreeTwoPattern {
	
	public static void main(String[] args) {
		boolean res = find132pattern(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10});
		System.out.println(res);
	}
	
	public static boolean find132pattern(int[] nums) {
		int second = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < second) {
				return true;
			}
			while (!stack.isEmpty() && nums[i] > stack.peek()) {
				second = stack.pop();
			}
			stack.push(nums[i]);
		}
		return false;
	}
}
