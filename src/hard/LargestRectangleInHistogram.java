package hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	public static void main(String[] args) {
		int res = largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
		System.out.println(res);
	}
	
	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int n = heights.length, res = 0;
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && heights[stack.peek()] > heights[i]) {
				int j = stack.pop();
				res = Math.max(res, heights[j] * (i - stack.peek() - 1));
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			int j = stack.pop();
			res = Math.max(res, heights[j] * (n - stack.peek() - 1));
		}
		return res;
	}
}
