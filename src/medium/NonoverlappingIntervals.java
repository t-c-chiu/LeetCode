package medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
	
	public static void main(String[] args) {
		int res = eraseOverlapIntervals(new int[][]{{1, 2}, {1, 3}, {3, 4}, {2, 3}});
		System.out.println(res);
	}
	
	public static int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
		int res = 0, end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				res++;
				end = Math.min(end, intervals[i][1]);
			} else {
				end = intervals[i][1];
			}
		}
		return res;
	}
}
