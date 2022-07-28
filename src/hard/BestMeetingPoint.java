package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestMeetingPoint {
	
	public static void main(String[] args) {
		int res = minTotalDistance(new int[][]{
				{1, 0, 0, 0, 1},
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0}});
		System.out.println(res);
	}
	
	public static int minTotalDistance(int[][] grid) {
		List<Integer> I = new ArrayList<>();
		List<Integer> J = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					I.add(i);
					J.add(j);
				}
			}
		}
		return getMin(I) + getMin(J);
	}
	
	private static int getMin(List<Integer> list) {
		list.sort(Comparator.naturalOrder());
		int res = 0, lo = 0, hi = list.size() - 1;
		while (lo < hi) {
			res += list.get(hi--) - list.get(lo++);
		}
		return res;
	}

//	private static int getMin(List<Integer> list) {
//		list.sort(Comparator.naturalOrder());
//		int median = list.get(list.size() / 2), res = 0;
//		for (Integer i : list) {
//			res += Math.abs(i - median);
//		}
//		return res;
//	}
}
