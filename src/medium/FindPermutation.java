package medium;

import java.util.Arrays;
import java.util.Stack;

public class FindPermutation {
	
	public static void main(String[] args) {
		int[] res = findPermutation("IIID");
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findPermutation(String s) {
		int[] res = new int[s.length() + 1];
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for (int i = 1; i <= s.length(); i++) {
			if (s.charAt(i - 1) == 'I') {
				res[j++] = i;
				while (!stack.isEmpty()) {
					res[j++] = stack.pop();
				}
			} else {
				stack.push(i);
			}
		}
		stack.push(s.length() + 1);
		while (!stack.isEmpty()) {
			res[j++] = stack.pop();
		}
		return res;
	}
	
}
