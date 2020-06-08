package medium;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
	
	public static void main(String[] args) {
		Evaluate_Reverse_Polish_Notation test = new Evaluate_Reverse_Polish_Notation();
		int res = test.evalRPN(new String[]{"2", "1", "+", "3", "*"});
		System.out.println(res);
	}
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int right = stack.pop();
				int left = stack.pop();
				switch (token) {
					case "+":
						stack.push(left + right);
						break;
					case "-":
						stack.push(left - right);
						break;
					case "*":
						stack.push(left * right);
						break;
					case "/":
						stack.push(left / right);
				}
			} else {
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
	}
}
