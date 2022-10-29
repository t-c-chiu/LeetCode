package medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	
	public static void main(String[] args) {
		int[] res = nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
				res[stack.pop()] = nums[i % n];
			}
			if (i < n) {
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}
		return res;
	}
}
