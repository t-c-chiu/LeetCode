package medium;

import java.util.Stack;

public class BasicCalculatorII {
	
	public static void main(String[] args) {
		int res = calculate("3+2* 2-5*4+6+7/2");
		System.out.println(res);
	}
	
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		char op = '+';
		int res = 0, i = 0, n = s.length();
		while (i < n) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < n && Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i++) - '0';
				}
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
						break;
				}
			} else {
				if (c == '+' || c == '-' || c == '*' || c == '/') {
					op = c;
				}
				i++;
			}
		}
		for (Integer num : stack) {
			res += num;
		}
		return res;
	}
}
