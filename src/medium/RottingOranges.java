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
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> rottens = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					rottens.offer(new int[]{i, j});
				}
			}
		}
		
		int res = 0;
		while (!rottens.isEmpty()) {
			int size = rottens.size();
			for (int i = 0; i < size; i++) {
				rotten(rottens, grid, rottens.poll());
			}
			
			if (!rottens.isEmpty()) {
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
	
	private static void rotten(Queue<int[]> rottens, int[][] grid, int[] rc) {
		int r = rc[0];
		int c = rc[1];
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int row = r + dir[0];
			int column = c + dir[1];
			if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
				continue;
			}
			if (grid[row][column] == 1) {
				grid[row][column] = 2;
				rottens.offer(new int[]{row, column});
			}
		}
	}
}
