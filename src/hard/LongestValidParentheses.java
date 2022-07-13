package hard;

import java.util.Stack;

public class LongestValidParentheses {
	
	public static void main(String[] args) {
		int res = longestValidParentheses("))))())()()(()");
		System.out.println(res);
	}
	
	public static int longestValidParentheses(String s) {
		int n = s.length();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}
		int res = 0;
		while (!stack.isEmpty()) {
			int last = stack.pop();
			res = Math.max(res, n - last - 1);
			n = last;
		}
		return Math.max(res, n);
	}
}
