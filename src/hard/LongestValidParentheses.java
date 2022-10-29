package hard;

import java.util.Stack;

public class LongestValidParentheses {
	
	public static void main(String[] args) {
		int res = longestValidParentheses("))))())()()(()");
		System.out.println(res);
	}
	
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
					stack.push(i);
				} else {
					stack.pop();
				}
			}
		}
		int last = n, res = 0;
		while (!stack.isEmpty()) {
			res = Math.max(res, last - stack.peek() - 1);
			last = stack.pop();
		}
		return Math.max(res, last);
	}
}
