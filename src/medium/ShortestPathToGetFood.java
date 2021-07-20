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
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '*') {
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[]{i, j});
					boolean[][] visited = new boolean[n][m];
					visited[i][j] = true;
					return bfs(grid, queue, visited);
				}
			}
		}
		return -1;
	}
	
	private static int bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
		int res = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cell = queue.poll();
				int r = cell[0];
				int c = cell[1];
				if (grid[r][c] == '#') {
					return res;
				}
				addAdjacentCells(grid, queue, visited, r, c);
			}
			res++;
		}
		return -1;
	}
	
	private static void addAdjacentCells(char[][] grid, Queue<int[]> queue, boolean[][] visited, int r, int c) {
		int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int[] dir : dirs) {
			int newR = r + dir[0];
			int newC = c + dir[1];
			if (newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length
					|| visited[newR][newC] || grid[newR][newC] == 'X') {
				continue;
			}
			visited[newR][newC] = true;
			queue.offer(new int[]{newR, newC});
		}
	}
	
}
