package hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorIII {
	
	public static void main(String[] args) {
		int res = calculate("(2+6*3+5-(3*14/7+2)*5)+3");
		System.out.print(res);
	}
	
	
	public static int calculate(String s) {
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			queue.offer(s.charAt(i));
		}
		return cal(queue);
	}
	
	private static int cal(Queue<Character> queue) {
		Stack<Integer> stack = new Stack<>();
		char op = '+';
		while (!queue.isEmpty()) {
			Character c = queue.poll();
			if (Character.isDigit(c)) {
				int num = c - '0';
				while (!queue.isEmpty() && Character.isDigit(queue.peek())) {
					num = num * 10 + (queue.poll() - '0');
				}
				pushToStack(stack, op, num);
			} else if (c == '(') {
				int num = cal(queue);
				pushToStack(stack, op, num);
			} else {
				op = c;
				if (c == ')') {
					break;
				}
			}
			
		}
		int res = 0;
		for (Integer i : stack) {
			res += i;
		}
		return res;
	}
	
	private static void pushToStack(Stack<Integer> stack, char op, int num) {
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
	}
}
