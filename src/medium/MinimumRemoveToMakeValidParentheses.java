package medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
	
	public static void main(String[] args) {
		String res = minRemoveToMakeValid("lee(t(c)o)de)");
		System.out.println(res);
		res = minRemoveToMakeValid("a)b(c)d");
		System.out.println(res);
		res = minRemoveToMakeValid("(a(b(c)d)");
		System.out.println(res);
		res = minRemoveToMakeValid("))((");
		System.out.println(res);
	}
	
	public static String minRemoveToMakeValid(String s) {
		StringBuilder builder = new StringBuilder(s);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case '(':
					stack.push(i);
					break;
				case ')':
					if (stack.isEmpty()) {
						builder.setCharAt(i, ' ');
					} else {
						stack.pop();
					}
					break;
			}
		}
		while (!stack.isEmpty()) {
			builder.setCharAt(stack.pop(), ' ');
		}
		return builder.toString().replaceAll(" ", "");
	}
	
	public static class Bracket {
		boolean open;
		int index;
		
		public Bracket(boolean open, int index) {
			this.open = open;
			this.index = index;
		}
	}
}
