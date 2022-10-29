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
			for (int i = q.size(); i > 0; i--) {
				int[] cur = q.poll();
				int r = cur[0], c = cur[1];
				for (int[] dir : dirs) {
					int rr = r + dir[0], cc = c + dir[1];
					if (rr < 0 || rr == m || cc < 0 || cc == n || grid[rr][cc] == 'X') {
						continue;
					}
					if (grid[rr][cc] == '#') {
						return res;
					}
					grid[rr][cc] = 'X';
					q.offer(new int[]{rr, cc});
				}
			}
			res++;
		}
		return -1;
	}
}
