package easy;

import java.util.Stack;

public class ValidParentheses {
	// (), {}, []

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid("[(){}]"));
		System.out.println(validParentheses.isValid("([]){}"));
		System.out.println(validParentheses.isValid("{[()]}"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch (c) {
				case '(':
					stack.add(')');
					break;
				case '[':
					stack.add(']');
					break;
				case '{':
					stack.add('}');
					break;
				default:
					if (stack.isEmpty() || stack.pop() != c)
						return false;
			}
		}
		return stack.isEmpty();
	}
}
