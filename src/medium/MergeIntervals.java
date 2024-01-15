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
			int[] last = list.get(list.size() - 1);
			int[] cur = intervals[i];
			if (last[1] >= cur[0]) {
				last[1] = Math.max(last[1], cur[1]);
			} else {
				list.add(cur);
			}
		}
		int[][] res = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
}
