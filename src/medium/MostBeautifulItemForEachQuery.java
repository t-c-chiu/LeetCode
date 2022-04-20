package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MostBeautifulItemForEachQuery {
	
	public static void main(String[] args) {
		int[] res = maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{1, 2, 3, 4, 5, 6});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] maximumBeauty(int[][] items, int[] queries) {
		int[] res = new int[queries.length];
		Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 0);
		int max = Integer.MIN_VALUE;
		for (int[] item : items) {
			max = Math.max(max, item[1]);
			map.put(item[0], max);
		}
		for (int i = 0; i < queries.length; i++) {
			res[i] = map.floorEntry(queries[i]).getValue();
		}
		return res;
	}
}
