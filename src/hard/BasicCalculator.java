package hard;

import java.util.Stack;

public class BasicCalculator {
	
	public static void main(String[] args) {
		int res = calculate("(1+(4+5+2)-3)+(6+8)");
		System.out.println(res);
	}
	
	public static int calculate(String s) {
		int res = 0, i = 0, sign = 1, n = s.length();
		Stack<Integer> stack = new Stack<>();
		while (i < n) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < n && Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
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
					sign = 1;
					res = 0;
				} else if (c == ')') {
					res *= stack.pop();
					res += stack.pop();
					sign = 1;
				}
				i++;
			}
		}
		return res;
	}
}

