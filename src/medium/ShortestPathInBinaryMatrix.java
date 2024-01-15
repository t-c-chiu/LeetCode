package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
	
	public static void main(String[] args) {
		int res = shortestPathBinaryMatrix(new int[][]{
				{0, 0, 0},
				{1, 1, 0},
				{1, 1, 0}
		});
		System.out.println(res);
	}
	
	
	public static int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length, res = 1;
		if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
			return -1;
		}
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 1}, {1, 0}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		grid[0][0] = 1;
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int[] poll = queue.poll();
				int x = poll[0], y = poll[1];
				if (x == n - 1 && y == n - 1) {
					return res;
				}
				for (int[] dir : dirs) {
					int nx = x + dir[0], ny = y + dir[1];
					if (nx < 0 || nx == n || ny < 0 || ny == n || grid[nx][ny] == 1) {
						continue;
					}
					queue.offer(new int[]{nx, ny});
					grid[nx][ny] = 1;
				}
			}
			res++;
		}
		return -1;
	}
	
}
