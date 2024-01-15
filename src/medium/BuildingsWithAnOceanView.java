package medium;

import java.util.*;

public class BuildingsWithAnOceanView {
	
	public static void main(String[] args) {
		int[] res = findBuildings(new int[]{4, 2, 2, 1});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findBuildings(int[] heights) {
		int n = heights.length, max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			if (heights[i] > max) {
				stack.push(i);
				max = heights[i];
			}
		}
		int[] res = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			res[i++] = stack.pop();
		}
		return res;
	}
}
