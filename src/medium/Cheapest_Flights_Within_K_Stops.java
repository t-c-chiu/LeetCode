package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Cheapest_Flights_Within_K_Stops {
	
	public static void main(String[] args) {
		Cheapest_Flights_Within_K_Stops test = new Cheapest_Flights_Within_K_Stops();
		int res = test.findCheapestPrice(5, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
		System.out.println(res);
	}
	
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
		for (int i = 0; i < flights.length; i++) {
			int city = flights[i][0];
			prices.putIfAbsent(city, new HashMap<>());
			prices.get(city).put(flights[i][1], flights[i][2]);
		}
		
		PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		queue.add(new Integer[]{0, src, K});
		while (!queue.isEmpty()) {
			Integer[] arr = queue.poll();
			int price = arr[0];
			int city = arr[1];
			int stop = arr[2];
			if (city == dst) {
				return price;
			}
			if (stop >= 0) {
				Map<Integer, Integer> map = prices.getOrDefault(city, new HashMap<>());
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					queue.add(new Integer[]{price + entry.getValue(), entry.getKey(), stop - 1});
				}
			}
		}
		return -1;
	}
}
