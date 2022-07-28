package medium;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
	
	public static void main(String[] args) {
		int res = findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1);
		System.out.println(res);
	}
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;
		for (int i = 0; i <= k; i++) {
			int[] temp = Arrays.copyOf(cost, n);
			for (int[] flight : flights) {
				int from = flight[0];
				int to = flight[1];
				int price = flight[2];
				if (cost[from] != Integer.MAX_VALUE) {
					temp[to] = Math.min(temp[to], cost[from] + price);
				}
			}
			cost = temp;
		}
		return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
	}
}
