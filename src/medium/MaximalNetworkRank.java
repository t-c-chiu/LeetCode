package medium;

import java.util.*;

public class MaximalNetworkRank {
	
	public static void main(String[] args) {
		int res = maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}});
		System.out.println(res);
	}
	
	public static int maximalNetworkRank(int n, int[][] roads) {
		Set<Integer>[] network = new Set[n];
		for (int i = 0; i < n; i++) {
			network[i] = new HashSet<>();
		}
		for (int[] road : roads) {
			int from = road[0], to = road[1];
			network[from].add(to);
			network[to].add(from);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				res = Math.max(res, network[i].size() + network[j].size() - (network[i].contains(j) ? 1 : 0));
			}
		}
		return res;
	}
	
}
