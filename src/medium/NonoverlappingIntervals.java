package medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
	
	public static void main(String[] args) {
		int res = eraseOverlapIntervals(new int[][]{{1, 2}, {1, 3}, {3, 4}, {2, 3}});
		System.out.println(res);
	}
	
	public static int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
		int res = 0, end = Integer.MIN_VALUE;
		for (int[] interval : intervals) {
			if (interval[0] < end) {
				res++;
			} else {
				end = interval[1];
			}
		}
		return res;
	}
}
