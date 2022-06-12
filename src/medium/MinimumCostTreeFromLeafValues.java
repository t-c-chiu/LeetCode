package medium;

import java.util.Arrays;
import java.util.Stack;

public class MinimumCostTreeFromLeafValues {
	
	public static void main(String[] args) {
		int res = mctFromLeafValues(new int[]{11, 12, 12});
		System.out.println(res);
	}
	
	public static int mctFromLeafValues(int[] arr) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.MAX_VALUE);
		for (int i : arr) {
			while (i >= stack.peek()) {
				int min = stack.pop();
				res += min * Math.min(stack.peek(), i);
				
			}
			stack.push(i);
		}
		while (stack.size() > 2) {
			res += stack.pop() * stack.peek();
		}
		return res;
	}
}
