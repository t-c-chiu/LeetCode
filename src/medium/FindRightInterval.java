package medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
	
	public static void main(String[] args) {
		int[] res = findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			map.put(intervals[i][0], i);
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
			res[i] = entry == null ? -1 : entry.getValue();
		}
		return res;
	}
}
