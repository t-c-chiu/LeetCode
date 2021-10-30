package medium;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
	
	public static void main(String[] args) {
		int res = removeCoveredIntervals(new int[][]{
				{1, 4}, {3, 6}, {2, 8}, {2, 3}, {1, 5}, {1, 6}
		});
		System.out.println(res);
	}
	
	public static int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
		});
		int res = 0, right = 0;
		for (int[] interval : intervals) {
			if (interval[1] > right) {
				res++;
				right = interval[1];
			}
		}
		return res;
	}
}
