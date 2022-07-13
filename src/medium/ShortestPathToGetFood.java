package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
	
	public static void main(String[] args) {
		int res = getFood(new char[][]{
				{'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', '*', 'O', 'O', 'O', 'X'},
				{'X', 'O', 'O', '#', 'O', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'X'},
		});
		System.out.println(res);
	}
	
	public static int getFood(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '*') {
					grid[i][j] = 'X';
					q.offer(new int[]{i, j});
					return bfs(grid, m, n, q);
				}
			}
		}
		return -1;
	}
	
	private static int bfs(char[][] grid, int m, int n, Queue<int[]> q) {
		int res = 1;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (!q.isEmpty()) {
			for (int k = q.size(); k > 0; k--) {
				int[] cur = q.poll();
				int x = cur[0], y = cur[1];
				for (int[] dir : dirs) {
					int newX = x + dir[0];
					int newY = y + dir[1];
					if (newX < 0 || newX == m || newY < 0 || newY == n || grid[newX][newY] == 'X') {
						continue;
					}
					if (grid[newX][newY] == '#') {
						return res;
					}
					grid[newX][newY] = 'X';
					q.offer(new int[]{newX, newY});
				}
			}
			res++;
		}
		return -1;
	}
}
