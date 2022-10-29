package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
	
	public static void main(String[] args) {
		int res = minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});
		System.out.println(res);
	}
	
	public static int minCostConnectPoints(int[][] points) {
		int n = points.length, res = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				pq.offer(new int[]{distance(points, i, j), i, j});
			}
		}
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		while (n > 1) {
			int[] edge = pq.poll();
			int p1 = find(parent, edge[1]);
			int p2 = find(parent, edge[2]);
			if (p1 != p2) {
				res += edge[0];
				n--;
				parent[p2] = p1;
			}
		}
		return res;
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
	
	private static int distance(int[][] points, int i, int j) {
		return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
	}
}
