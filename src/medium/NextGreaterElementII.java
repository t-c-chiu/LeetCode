package medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	
	public static void main(String[] args) {
		int[] res = nextGreaterElements(new int[]{2, 1, 2, 4, 3});
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 1 2 3 4 3 1 2 3 4 3
	 */
	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			int num = nums[i % n];
			while (!stack.isEmpty() && nums[stack.peek()] < num) {
				res[stack.pop()] = num;
			}
			if (i < n) {
				stack.push(i);
			}
		}
		return res;
	}
}
