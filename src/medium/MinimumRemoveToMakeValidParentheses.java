package medium;

import java.util.HashSet;
import java.util.Set;
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
		int n = s.length();
		Stack<Integer> stack = new Stack<>();
		Set<Integer> toRemove = new HashSet<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			}
			if (c == ')') {
				if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
					toRemove.add(i);
				} else {
					stack.pop();
				}
			}
		}
		toRemove.addAll(stack);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (!toRemove.contains(i)) {
				builder.append(s.charAt(i));
			}
		}
		return builder.toString();
	}
	
}
