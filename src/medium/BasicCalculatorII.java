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
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				switch (op) {
					case '+' -> stack.push(num);
					case '-' -> stack.push(-num);
					case '*' -> stack.push(stack.pop() * num);
					case '/' -> stack.push(stack.pop() / num);
				}
			} else {
				if (!Character.isWhitespace(c)) {
					op = c;
				}
				i++;
			}
		}
		return stack.stream().mapToInt(num -> num).sum();
	}
}
