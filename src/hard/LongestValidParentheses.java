package hard;

import java.util.Stack;

public class LongestValidParentheses {
	
	public static void main(String[] args) {
		int res = longestValidParentheses("))))())()()(()");
		System.out.println(res);
	}
	
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
			} else {
				stack.push(i);
			}
		}
		int prev = -1, res = 0;
		for (Integer i : stack) {
			res = Math.max(res, i - prev - 1);
			prev = i;
		}
		return Math.max(res, s.length() - prev - 1);
	}
}
