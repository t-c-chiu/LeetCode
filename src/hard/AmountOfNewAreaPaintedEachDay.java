package hard;

import java.util.Arrays;
import java.util.TreeMap;

public class AmountOfNewAreaPaintedEachDay {
	
	public static void main(String[] args) {
		int[] res = amountPainted(new int[][]{{2, 5}, {7, 10}, {3, 9}});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] amountPainted(int[][] paint) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int n = paint.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int start = paint[i][0];
			int end = paint[i][1];
			int area = end - start;
			while (map.floorKey(end) != null) {
				int preStart = map.floorKey(end);
				int preEnd = map.get(preStart);
				if (preEnd < start) {
					break;
				}
				area -= Math.min(end, preEnd) - Math.max(start, preStart);
				map.remove(preStart);
				start = Math.min(start, preStart);
				end = Math.max(end, preEnd);
			}
			res[i] = area;
			map.put(start, end);
		}
		return res;
	}
}
