package medium;

import java.util.TreeMap;

public class CarPooling {
	
	public static void main(String[] args) {
		boolean res = carPooling(new int[][]{{7, 5, 6}, {6, 7, 8}, {10, 1, 6}}, 16);
		System.out.println(res);
	}
	
	public static boolean carPooling(int[][] trips, int capacity) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int[] trip : trips) {
			int passengers = trip[0], from = trip[1], to = trip[2];
			map.put(from, map.getOrDefault(from, 0) + passengers);
			map.put(to, map.getOrDefault(to, 0) - passengers);
		}
		for (int passengers : map.values()) {
			capacity -= passengers;
			if (capacity < 0) {
				return false;
			}
		}
		return true;
	}

//	public static boolean carPooling(int[][] trips, int capacity) {
//		Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
//		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//		for (int[] trip : trips) {
//			while (!pq.isEmpty() && pq.peek()[0] <= trip[1]) {
//				capacity += pq.poll()[1];
//			}
//			if (capacity < trip[0]) {
//				return false;
//			}
//			capacity -= trip[0];
//			pq.offer(new int[]{trip[2], trip[0]});
//		}
//		return true;
//	}
}
