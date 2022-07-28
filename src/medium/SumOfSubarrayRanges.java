package medium;

import java.util.Stack;

public class SumOfSubarrayRanges {
	
	public static void main(String[] args) {
		long res = subArrayRanges(new int[]{1, 2, 3});
		System.out.println(res);
	}
	
	public static long subArrayRanges(int[] nums) {
		int n = nums.length;
		long res = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && nums[stack.peek()] < nums[i]) {
				Integer cur = stack.pop();
				res += (long) nums[cur] * (cur - stack.peek()) * (i - cur);
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			Integer cur = stack.pop();
			res += (long) nums[cur] * (cur - stack.peek()) * (n - cur);
		}
		stack.clear();
		stack.push(-1);
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && nums[stack.peek()] > nums[i]) {
				Integer cur = stack.pop();
				res -= (long) nums[cur] * (cur - stack.peek()) * (i - cur);
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			Integer cur = stack.pop();
			res -= (long) nums[cur] * (cur - stack.peek()) * (n - cur);
		}
		return res;
	}

//	public static long subArrayRanges(int[] nums) {
//		long res = 0;
//		for (int i = 0; i < nums.length; i++) {
//			int max = nums[i], min = nums[i];
//			for (int j = i + 1; j < nums.length; j++) {
//				max = Math.max(max, nums[j]);
//				min = Math.min(min, nums[j]);
//				res += max - min;
//			}
//		}
//		return res;
//	}
}
