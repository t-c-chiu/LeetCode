package medium;

import java.util.Stack;

public class DailyTemperatures {
	
	public static void main(String[] args) {
		for (int i : new DailyTemperatures().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {
			System.out.print(i);
		}
	}
	
	public int[] dailyTemperatures(int[] T) {
		int len = T.length;
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (T[j] > T[i]) {
					res[i] = j - i;
					break;
				}
			}
		}
		return res;
	}
	
	public int[] dailyTemperatures2(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int idx = stack.pop();
				res[idx] = i - idx;
			}
			stack.push(i);
		}
		return res;
	}
}
