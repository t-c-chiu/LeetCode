package hard;

import java.util.Stack;

public class MaximumNumberOfBooksYouCanTake {
	
	public static void main(String[] args) {
		long res = maximumBooks(new int[]{0, 3, 1, 5, 4});
		System.out.println(res);
	}
	
	public static long maximumBooks(int[] books) {
		int n = books.length;
		long res = 0;
		long[] dp = new long[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && books[stack.peek()] >= books[i] - i + stack.peek()) {
				stack.pop();
			}
			int j = stack.isEmpty() ? -1 : stack.peek();
			dp[i] = sum(Math.max(0, books[i] - i + j + 1), books[i]) + (j >= 0 ? dp[j] : 0);
			res = Math.max(res, dp[i]);
			stack.push(i);
		}
		return res;
	}
	
	public static long sum(long from, long to) {
		return (from + to) * (to - from + 1) / 2;
	}
}
