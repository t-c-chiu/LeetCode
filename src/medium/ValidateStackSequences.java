package medium;

import java.util.Stack;

public class ValidateStackSequences {
	
	public static void main(String[] args) {
		boolean res = validateStackSequences(new int[]{1, 0}, new int[]{1, 0});
		System.out.println(res);
	}
	
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for (int i = 0; i < pushed.length; i++) {
			stack.push(pushed[i]);
			while (!stack.isEmpty() && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}
		return stack.isEmpty();
	}
}
