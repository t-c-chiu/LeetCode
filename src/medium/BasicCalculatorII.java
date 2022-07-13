package medium;

import java.util.Stack;

public class BasicCalculatorII {
	
	public static void main(String[] args) {
		int res = calculate("3+2* 2");
		System.out.println(res);
	}
	
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int num = 0, n = s.length();
		char op = '+';
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
				switch (op) {
					case '+':
						stack.push(num);
						break;
					case '-':
						stack.push(-num);
						break;
					case '*':
						stack.push(stack.pop() * num);
						break;
					case '/':
						stack.push(stack.pop() / num);
				}
				num = 0;
				op = c;
			}
		}
		return stack.stream().mapToInt(i -> i).sum();
	}
}
