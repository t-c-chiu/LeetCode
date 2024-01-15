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
		int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int[][] maxK = new int[m][n];
		for (int[] row : maxK) {
			Arrays.fill(row, -1);
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0, k});
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int[] poll = queue.poll();
				int x = poll[0], y = poll[1];
				if (x == m - 1 && y == n - 1) {
					return res;
				}
				for (int[] dir : dirs) {
					int nx = x + dir[0], ny = y + dir[1], curK = poll[2];
					if (nx < 0 || nx == m || ny < 0 || ny == n ||
							maxK[nx][ny] >= curK || grid[nx][ny] == 1 && curK == 0) {
						continue;
					}
					if (grid[nx][ny] == 1) {
						curK--;
					}
					maxK[nx][ny] = curK;
					queue.offer(new int[]{nx, ny, curK});
				}
			}
			res++;
		}
		return -1;
	}
	
}
