package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
	
	public static void main(String[] args) {
		int res = shortestPath(new int[][]{
				{0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1, 0},
				{0, 0, 0, 1, 1, 0},
				{0, 1, 0, 1, 0, 0},
				{0, 1, 1, 1, 1, 1},
				{0, 1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0, 0}}, 1);
		System.out.println(res);
	}
	
	public static int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length, res = 0;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int[][] maxK = new int[m][n];
		for (int[] row : maxK) {
			Arrays.fill(row, -1);
		}
		maxK[0][0] = k;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0, 0, k});
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				int[] cur = q.poll();
				int x = cur[0], y = cur[1];
				if (x == m - 1 && y == n - 1) {
					return res;
				}
				for (int[] dir : dirs) {
					int nextX = x + dir[0], nextY = y + dir[1], kLeft = cur[2];
					if (nextX < 0 || nextX == m || nextY < 0 || nextY == n ||
							grid[nextX][nextY] == 1 && kLeft == 0 || maxK[nextX][nextY] >= kLeft) {
						continue;
					}
					if (grid[nextX][nextY] == 1) {
						kLeft--;
					}
					maxK[nextX][nextY] = kLeft;
					q.offer(new int[]{nextX, nextY, kLeft});
				}
			}
			res++;
		}
		return -1;
	}
}
