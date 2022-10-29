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
		list.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] cur = list.get(list.size() - 1);
			if (cur[1] >= intervals[i][0]) {
				cur[1] = Math.max(cur[1], intervals[i][1]);
			} else {
				list.add(intervals[i]);
			}
		}
		int[][] res = new int[list.size()][2];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
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
