package medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	
	public static void main(String[] args) {
		int[][] res = insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		int n = intervals.length;
		if (n == 0) {
			return new int[][]{newInterval};
		}
		
		List<int[]> list = new ArrayList<>();
		int i = 0;
		while (i < n && intervals[i][1] < newInterval[0]) {
			list.add(intervals[i]);
			i++;
		}
		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		list.add(newInterval);
		while (i < n) {
			list.add(intervals[i]);
			i++;
		}
		
		int[][] res = new int[list.size()][2];
		for (int j = 0; j < res.length; j++) {
			res[j] = list.get(j);
		}
		return res;
	}
}
