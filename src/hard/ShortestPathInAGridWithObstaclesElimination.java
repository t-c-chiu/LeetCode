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
		int[][] maxKLeft = new int[m][n];
		for (int[] row : maxKLeft) {
			Arrays.fill(row, -1);
		}
		maxKLeft[0][0] = k;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0, k});
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int[] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				if (r == m - 1 && c == n - 1) {
					return res;
				}
				for (int[] dir : dirs) {
					int nr = r + dir[0];
					int nc = c + dir[1];
					int kLeft = cur[2];
					if (nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] == 1 && kLeft == 0 || maxKLeft[nr][nc] >= kLeft) {
						continue;
					}
					if (grid[nr][nc] == 1) {
						kLeft--;
					}
					maxKLeft[nr][nc] = kLeft;
					queue.offer(new int[]{nr, nc, kLeft});
				}
			}
			res++;
		}
		return -1;
	}
}
