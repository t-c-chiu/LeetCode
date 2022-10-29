package medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	
	public static void main(String[] args) {
		int res = orangesRotting(new int[][]{
				{2, 1, 1},
				{1, 1, 0},
				{0, 1, 1}
		});
		System.out.println(res);
	}
	
	public static int orangesRotting(int[][] grid) {
		int m = grid.length, n = grid[0].length, res = 0;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[]{i, j});
				}
			}
		}
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int[] cur = queue.poll();
				for (int[] dir : dirs) {
					int r = cur[0] + dir[0], c = cur[1] + dir[1];
					if (r < 0 || r == m || c < 0 || c == n || grid[r][c] != 1) {
						continue;
					}
					grid[r][c] = 2;
					queue.offer(new int[]{r, c});
				}
			}
			if (!queue.isEmpty()) {
				res++;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return res;
	}
	
}
