package medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectangles {
	
	public static void main(String[] args) {
		long res = interchangeableRectangles(new int[][]{
				{4, 8},
				{3, 6},
				{10, 20},
				{500, 1000},
		});
		System.out.println(res);
	}
	
	public static long interchangeableRectangles(int[][] rectangles) {
		long res = 0;
		Map<Double, Integer> map = new HashMap<>();
		for (int[] rectangle : rectangles) {
			double ratio = (double) rectangle[0] / rectangle[1];
			map.put(ratio, map.getOrDefault(ratio, 0) + 1);
		}
		for (Integer count : map.values()) {
			res += (long) count * (count - 1) / 2;
		}
		return res;
	}

//	public static long interchangeableRectangles(int[][] rectangles) {
//		long res = 0;
//		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
//		for (int[] rectangle : rectangles) {
//			int[] ratio = getRatio(rectangle);
//			map.putIfAbsent(ratio[0], new HashMap<>());
//			Map<Integer, Integer> ratioCount = map.get(ratio[0]);
//			Integer count = ratioCount.getOrDefault(ratio[1], 0);
//			res += count;
//			ratioCount.put(ratio[1], count + 1);
//		}
//		return res;
//	}
//
//	private static int[] getRatio(int[] rectangle) {
//		int gcd = gcd(rectangle[0], rectangle[1]);
//		return new int[]{rectangle[0] / gcd, rectangle[1] / gcd};
//	}
//
//	private static int gcd(int num1, int num2) {
//		if (num2 == 0) {
//			return num1;
//		}
//		if (num1 < num2) {
//			return gcd(num2, num1);
//		}
//		return gcd(num2, num1 % num2);
//	}
}
