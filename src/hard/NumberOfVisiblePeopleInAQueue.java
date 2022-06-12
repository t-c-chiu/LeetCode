package hard;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue {
	
	public static void main(String[] args) {
		int[] res = canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] canSeePersonsCount(int[] heights) {
		int n = heights.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			int count = 0;
			while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
				stack.pop();
				count++;
			}
			if (!stack.isEmpty()) {
				count++;
			}
			res[i] = count;
			stack.push(i);
		}
		return res;
	}
}
