package medium;

import java.util.*;

public class DescribeThePainting {
	
	public static void main(String[] args) {
		List<List<Long>> res = splitPainting(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}});
		System.out.println(res);
	}
	
	public static List<List<Long>> splitPainting(int[][] segments) {
		List<List<Long>> res = new ArrayList<>();
		TreeMap<Integer, Long> map = new TreeMap<>();
		for (int[] segment : segments) {
			int start = segment[0], end = segment[1], color = segment[2];
			map.put(start, map.getOrDefault(start, 0L) + color);
			map.put(end, map.getOrDefault(end, 0L) - color);
		}
		long prev = 0, sum = 0;
		for (Integer cur : map.keySet()) {
			if (sum > 0) {
				res.add(Arrays.asList(prev, (long) cur, sum));
			}
			sum += map.get(cur);
			prev = cur;
		}
		return res;
	}
}
