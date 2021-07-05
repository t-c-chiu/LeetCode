package medium;

import java.util.*;

public class LineReflection {
	
	public static void main(String[] args) {
		boolean res = isReflected(new int[][]{
				{0, 0},
				{1, 1},
				{-3, 2},
				{3, 2},
		});
		System.out.println(res);
	}
	
	public static boolean isReflected(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int[] point : points) {
			int x = point[0];
			int y = point[1];
			map.putIfAbsent(y, new HashSet<>());
			map.get(y).add(x);
			max = Math.max(max, x);
			min = Math.min(min, x);
		}
		
		int sum = max + min;
		for (Set<Integer> set : map.values()) {
			for (Integer x : set) {
				if (!set.contains(sum - x)) {
					return false;
				}
			}
		}
		return true;
	}
}
