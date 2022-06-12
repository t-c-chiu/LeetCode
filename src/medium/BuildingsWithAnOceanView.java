package medium;

import java.util.*;

public class BuildingsWithAnOceanView {
	
	public static void main(String[] args) {
		int[] res = findBuildings(new int[]{4, 2, 2, 1});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findBuildings(int[] heights) {
		int highest = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = heights.length - 1; i >= 0; i--) {
			if (heights[i] > highest) {
				list.add(i);
				highest = heights[i];
			}
		}
		int[] res = new int[list.size()];
		for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
			res[j] = list.get(i);
		}
		return res;
	}
//	public static int[] findBuildings(int[] heights) {
//		Stack<Integer> stack = new Stack<>();
//		for (int i = 0; i < heights.length; i++) {
//			while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
//				stack.pop();
//			}
//			stack.push(i);
//		}
//		int[] res = new int[stack.size()];
//		int i = 0;
//		for (Integer index : stack) {
//			res[i++] = index;
//		}
//		return res;
//	}
}
