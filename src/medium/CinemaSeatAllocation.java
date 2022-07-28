package medium;

import java.util.*;

public class CinemaSeatAllocation {
	
	public static void main(String[] args) {
		int res = maxNumberOfFamilies(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}});
		System.out.println(res);
	}
	
	public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] reservedSeat : reservedSeats) {
			int row = reservedSeat[0];
			int col = reservedSeat[1];
			map.putIfAbsent(row, new HashSet<>());
			map.get(row).add(col);
		}
		int res = (n - map.size()) * 2;
		for (Set<Integer> seats : map.values()) {
			boolean tryMiddle = true;
			if (!seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5)) {
				res++;
				tryMiddle = false;
			}
			if (!seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9)) {
				res++;
				tryMiddle = false;
			}
			if (tryMiddle && !seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7)) {
				res++;
			}
		}
		return res;
	}
}
