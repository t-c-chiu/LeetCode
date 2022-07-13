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
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case '(':
					stack.push(')');
					break;
				case '[':
					stack.push(']');
					break;
				case '{':
					stack.push('}');
					break;
				default:
					if (stack.isEmpty() || stack.pop() != c) {
						return false;
					}
			}
		}
		return stack.isEmpty();
	}
}
