package medium;

import java.util.Stack;

public class SumOfSubarrayRanges {
	
	public static void main(String[] args) {
		long res = subArrayRanges(new int[]{4, -2, -3, 4, 1});
		System.out.println(res);
	}
	
	public static long subArrayRanges(int[] nums) {
		long res = 0;
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		// subtract min number in subarrays
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && nums[stack.peek()] > nums[i]) {
				int cur = stack.pop();
				res -= (long) nums[cur] * (cur - stack.peek()) * (i - cur);
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			int cur = stack.pop();
			res -= (long) nums[cur] * (cur - stack.peek()) * (n - cur);
		}
		// add max number in subarrays
		stack.clear();
		stack.push(-1);
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && nums[stack.peek()] < nums[i]) {
				int cur = stack.pop();
				res += (long) nums[cur] * (cur - stack.peek()) * (i - cur);
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			int cur = stack.pop();
			res += (long) nums[cur] * (cur - stack.peek()) * (n - cur);
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
