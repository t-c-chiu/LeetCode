package medium;

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
	
	public static void main(String[] args) {
		int res = findTheCity(4, new int[][]{
				{0, 1, 3},
				{1, 2, 1},
				{1, 3, 4},
				{2, 3, 1},
		}, 4);
		System.out.println(res);
	}
	
	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] dis = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dis[i], 10001);
			dis[i][i] = 0;
		}
		
		for (int[] edge : edges) {
			int city1 = edge[0];
			int city2 = edge[1];
			dis[city1][city2] = dis[city2][city1] = edge[2];
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
				}
			}
		}
		
		int res = 0;
		int minCount = n;
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (dis[i][j] <= distanceThreshold) {
					count++;
				}
			}
			if (count <= minCount) {
				res = i;
				minCount = count;
			}
		}
		return res;
	}
}
