package medium;

import java.util.Stack;

public class BasicCalculatorII {
	
	public static void main(String[] args) {
		int res = calculate("3+2* 2");
		System.out.println(res);
	}
	
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int n = s.length();
		int res = 0;
		int num = 0;
		char sign = '+';
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			}
			if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
				switch (sign) {
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
						break;
				}
				sign = c;
				num = 0;
			}
		}
		for (Integer i : stack) {
			res += i;
		}
		return res;
	}
}
