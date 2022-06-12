package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SumOfSubarrayMinimums {
	
	public static void main(String[] args) {
		int res = sumSubarrayMins(new int[]{11, 81, 94, 43, 3});
		System.out.println(res);
	}
	
	/**
	 * sum for a certain number = number * (index - leftSmallerIndex) * (rightSmallerIndex - index)
	 */
	public static int sumSubarrayMins(int[] arr) {
		int n = arr.length, mod = (int) 1e9 + 7;
		long res = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
				int cur = stack.pop();
				res += ((long) arr[cur] * (cur - stack.peek()) * (i - cur)) % mod;
				res %= mod;
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			int cur = stack.pop();
			res += ((long) arr[cur] * (cur - stack.peek()) * (n - cur)) % mod;
			res %= mod;
		}
		return (int) res;
	}
}
