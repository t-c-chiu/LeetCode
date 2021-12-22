package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildingsWithAnOceanView {
	
	public static void main(String[] args) {
		int[] res = findBuildings(new int[]{2, 2, 2, 2});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findBuildings(int[] heights) {
		List<Integer> list = new ArrayList<>();
		int highest = 0;
		for (int i = heights.length - 1; i >= 0; i--) {
			if (heights[i] > highest) {
				list.add(i);
				highest = heights[i];
			}
		}
		int[] res = new int[list.size()];
		for (int i = res.length - 1, j = 0; i >= 0; i--, j++) {
			res[j] = list.get(i);
		}
		return res;
	}
}
