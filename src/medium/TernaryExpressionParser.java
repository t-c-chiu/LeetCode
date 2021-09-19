package medium;

import java.util.Stack;

public class TernaryExpressionParser {
	
	public static void main(String[] args) {
		String res = parseTernary("T?T:F?T?1:2:F?3:4");
		System.out.println(res);
	}
	
	public static String parseTernary(String expression) {
		Stack<Character> stack = new Stack<>();
		char[] chars = expression.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			char c = chars[i];
			if (c == '?') {
				char left = stack.pop();
				char right = stack.pop();
				char tf = chars[--i];
				stack.push(tf == 'T' ? left : right);
			} else if (c != ':') {
				stack.push(c);
			}
		}
		return String.valueOf(stack.pop());
	}
}
