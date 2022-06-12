package medium;

import java.util.Stack;

public class MaximumSubarrayMinProduct {
	
	public static void main(String[] args) {
		int res = maxSumMinProduct(new int[]{3, 1, 5, 6, 4, 2});
		System.out.println(res);
	}
	
	public static int maxSumMinProduct(int[] nums) {
		int n = nums.length;
		long res = 0;
		long[] preSum = new long[n + 1];
		for (int i = 0; i < n; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <= n; i++) {
			while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
				int cur = stack.pop();
				res = Math.max(res, nums[cur] * (preSum[i] - preSum[stack.isEmpty() ? 0 : stack.peek() + 1]));
			}
			stack.push(i);
		}
		return (int) (res % 1000000007);
	}
}
