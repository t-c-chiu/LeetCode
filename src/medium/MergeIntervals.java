package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
		int[][] res = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		List<int[]> list = new ArrayList<>();
		int[] cur = intervals[0];
		list.add(cur);
		for (int[] interval : intervals) {
			if (interval[0] <= cur[1]) {
				cur[1] = Math.max(cur[1], interval[1]);
			} else {
				cur = interval;
				list.add(cur);
			}
		}
		return list.toArray(new int[list.size()][]);
	}

//	public static int[][] merge(int[][] intervals) {
//		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//		List<int[]> list = new ArrayList<>();
//		int start = intervals[0][0], end = intervals[0][1];
//		for (int i = 1; i < intervals.length; i++) {
//			int[] interval = intervals[i];
//			if (interval[0] <= end) {
//				end = Math.max(end, interval[1]);
//			} else {
//				list.add(new int[]{start, end});
//				start = interval[0];
//				end = interval[1];
//			}
//		}
//		list.add(new int[]{start, end});
//		return list.toArray(new int[list.size()][]);
//	}
}
