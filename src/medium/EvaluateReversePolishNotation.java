package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public static void main(String[] args) {
		int res = evalRPN(new String[]{"2", "1", "+", "3", "*"});
		System.out.println(res);
	}
	
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
		for (String token : tokens) {
			if (ops.contains(token)) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				switch (token) {
					case "+":
						stack.push(num1 + num2);
						break;
					case "-":
						stack.push(num1 - num2);
						break;
					case "*":
						stack.push(num1 * num2);
						break;
					case "/":
						stack.push(num1 / num2);
				}
			} else {
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
	}
}
