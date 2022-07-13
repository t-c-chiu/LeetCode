package hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	public static void main(String[] args) {
		int res = largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
		System.out.println(res);
	}
	
	public static int largestRectangleArea(int[] heights) {
		int res = 0,n=heights.length;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < n; i++) {
			while (stack.size() > 1 && heights[stack.peek()] > heights[i]) {
				Integer base = stack.pop();
				res = Math.max(res, heights[base] * (i - stack.peek() - 1));
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			res = Math.max(res, heights[stack.pop()] * (n - stack.peek() - 1));
		}
		return res;
	}

//	public static int largestRectangleArea(int[] heights) {
//		Stack<Integer> stack = new Stack<>();
//		stack.push(-1);
//		int n = heights.length, res = 0;
//		for (int i = 0; i < n; i++) {
//			while (stack.size() > 1 && heights[stack.peek()] > heights[i]) {
//				int cur = heights[stack.pop()];
//				res = Math.max(res, cur * (i - stack.peek() - 1));
//			}
//			stack.push(i);
//		}
//		while (stack.size() > 1) {
//			int cur = heights[stack.pop()];
//			res = Math.max(res, cur * (n - stack.peek() - 1));
//		}
//		return res;
//	}
}
