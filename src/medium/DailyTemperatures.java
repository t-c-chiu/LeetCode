package medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
	
	public static void main(String[] args) {
		int[] res = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			int temp = temperatures[i];
			while (!stack.empty() && temp > temperatures[stack.peek()]) {
				int j = stack.pop();
				res[j] = i - j;
			}
			stack.push(i);
		}
		return res;
	}
}
