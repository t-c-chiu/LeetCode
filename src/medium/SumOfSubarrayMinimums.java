package medium;

import java.util.Stack;

public class SumOfSubarrayMinimums {
	
	public static void main(String[] args) {
		int res = sumSubarrayMins(new int[]{11, 81, 94, 43, 3});
		System.out.println(res);
	}
	
	public static int sumSubarrayMins(int[] arr) {
		long res = 0;
		int mod = (int) (1e9 + 7), n = arr.length;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
				int cur = stack.pop();
				res = (res + (long) arr[cur] * (cur - stack.peek()) * (i - cur)) % mod;
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			int cur = stack.pop();
			res = (res + (long) arr[cur] * (cur - stack.peek()) * (n - cur)) % mod;
		}
		return (int) res;
	}
}
