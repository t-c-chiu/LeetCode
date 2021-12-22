package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
	
	public static void main(String[] args) {
		int res = shortestBridge(new int[][]{
				{1, 1, 1, 1, 1},
				{1, 0, 0, 0, 1},
				{1, 0, 1, 0, 1},
				{1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1}}
		);
		System.out.println(res);
	}
	
	static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static int shortestBridge(int[][] grid) {
		int n = grid.length, res = 0;
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, queue, visited, i, j);
					break;
				}
			}
			if (!queue.isEmpty()) {
				break;
			}
		}
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				for (int[] dir : dirs) {
					int x = poll[0] + dir[0];
					int y = poll[1] + dir[1];
					if (x < 0 || x == n || y < 0 || y == n || visited[x][y]) {
						continue;
					}
					if (grid[x][y] == 1) {
						return res;
					}
					visited[x][y] = true;
					queue.offer(new int[]{x, y});
				}
			}
			res++;
		}
		return res;
	}
	
	private static void dfs(int[][] grid, Queue<int[]> queue, boolean[][] visited, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid.length || visited[i][j] || grid[i][j] == 0) {
			return;
		}
		visited[i][j] = true;
		queue.offer(new int[]{i, j});
		for (int[] dir : dirs) {
			dfs(grid, queue, visited, i + dir[0], j + dir[1]);
		}
	}
}
