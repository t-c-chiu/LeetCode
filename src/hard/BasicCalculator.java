package hard;

import java.util.Stack;

public class BasicCalculator {
	
	public static void main(String[] args) {
		int res = calculate("2147483647");
		System.out.println(res);
	}
	
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int sign = 1, res = 0, n = s.length(), i = 0;
		while (i < n) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < n && Character.isDigit(s.charAt(i))) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
				res += num * sign;
			} else {
				if (c == '+') {
					sign = 1;
				} else if (c == '-') {
					sign = -1;
				} else if (c == '(') {
					stack.push(res);
					stack.push(sign);
					res = 0;
					sign = 1;
				} else if (c == ')') {
					res *= stack.pop();
					res += stack.pop();
				}
				i++;
			}
		}
		return res;
	}
}

