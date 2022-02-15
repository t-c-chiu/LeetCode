package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {
	
	public static void main(String[] args) {
		int[] res = nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			int num = nums[i % n];
			while (!stack.isEmpty() && num > nums[stack.peek()]) {
				res[stack.pop()] = num;
			}
			if (i < n) {
				stack.push(i);
			}
		}
		return res;
	}
//	public static int[] nextGreaterElements(int[] nums) {
//		int n = nums.length;
//		int[] res = new int[n];
//		Stack<Integer> stack = new Stack<>();
//		for (int i = 0; i < n; i++) {
//			int num = nums[i];
//			while (!stack.isEmpty() && num > nums[stack.peek()]) {
//				res[stack.pop()] = num;
//			}
//			stack.push(i);
//		}
//		for (int i = 0; i < n; i++) {
//			int num = nums[i];
//			while (!stack.isEmpty() && num > nums[stack.peek()]) {
//				res[stack.pop()] = num;
//			}
//		}
//		while (!stack.empty()) {
//			res[stack.pop()] = -1;
//		}
//		return res;
//	}
}
