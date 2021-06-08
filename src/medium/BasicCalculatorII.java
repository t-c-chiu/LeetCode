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
		int curNum = 0;
		char operation = '+';
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				curNum = curNum * 10 + (c - '0');
			}
			if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
				switch (operation) {
					case '+':
						stack.push(curNum);
						break;
					case '-':
						stack.push(-curNum);
						break;
					case '*':
						stack.push(stack.pop() * curNum);
						break;
					case '/':
						stack.push(stack.pop() / curNum);
						break;
				}
				operation = c;
				curNum = 0;
			}
		}
		
		return stack.stream().mapToInt(i -> i).sum();
	}
}
