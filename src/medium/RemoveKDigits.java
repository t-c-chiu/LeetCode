package medium;

import java.util.Stack;

public class RemoveKDigits {
	
	public static void main(String[] args) {
		String res = removeKdigits("112", 1);
		System.out.println(res);
	}
	
	public static String removeKdigits(String num, int k) {
		if (k >= num.length()) {
			return "0";
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			while (!stack.isEmpty() && c < stack.peek() && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(c);
		}
		while (k > 0) {
			stack.pop();
			k--;
		}
		StringBuilder builder = new StringBuilder();
		for (Character c : stack) {
			builder.append(c);
		}
		while (builder.length() > 1 && builder.charAt(0) == '0') {
			builder.deleteCharAt(0);
		}
		return builder.toString();
	}
}
