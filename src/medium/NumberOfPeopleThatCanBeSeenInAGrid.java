package medium;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfPeopleThatCanBeSeenInAGrid {
	
	public static void main(String[] args) {
		int[][] res = seePeople(new int[][]{{4, 2, 1, 1, 3}});
		Arrays.stream(res).forEach(arr -> {
			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
			System.out.println();
		});
	}
	
	public static int[][] seePeople(int[][] heights) {
		int m = heights.length, n = heights[0].length;
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			Stack<Integer> stack = new Stack<>();
			for (int j = n - 1; j >= 0; j--) {
				while (!stack.isEmpty() && heights[i][j] > heights[i][stack.peek()]) {
					res[i][j]++;
					stack.pop();
				}
				if (!stack.isEmpty()) {
					res[i][j]++;
				}
				if (stack.isEmpty() || heights[i][j] != heights[i][stack.peek()]) {
					stack.push(j);
				}
			}
		}
		for (int j = 0; j < n; j++) {
			Stack<Integer> stack = new Stack<>();
			for (int i = m - 1; i >= 0; i--) {
				while (!stack.isEmpty() && heights[i][j] > heights[stack.peek()][j]) {
					res[i][j]++;
					stack.pop();
				}
				if (!stack.isEmpty()) {
					res[i][j]++;
				}
				if (stack.isEmpty() || heights[i][j] != heights[stack.peek()][j]) {
					stack.push(i);
				}
			}
		}
		return res;
	}
}
