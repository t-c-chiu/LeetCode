package medium;

import java.util.*;

public class Merge_Intervals {
	
	public static void main(String[] args) {
		int[][] res = merge(new int[][]{
				{1, 3},
				{2, 6},
				{15, 18},
				{8, 10},
				{7, 81}
		});
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		List<int[]> res = new ArrayList<>();
		int[] curInterval = intervals[0];
		res.add(curInterval);
		for (int i = 1; i < intervals.length; i++) {
			int[] newInterval = intervals[i];
			if (newInterval[0] <= curInterval[1]) {
				curInterval[1] = Math.max(curInterval[1], newInterval[1]);
			} else {
				res.add(newInterval);
				curInterval = newInterval;
			}
		}
		return res.toArray(new int[res.size()][]);
	}
}
