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
		int m = grid.length, n = grid[0].length;
		if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
			return -1;
		}
		
		int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		int res = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] node = queue.poll();
				if (node[0] == m - 1 && node[1] == n - 1) {
					return res;
				}
				for (int[] dir : dirs) {
					int x = node[0] + dir[0];
					int y = node[1] + dir[1];
					if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
						queue.offer(new int[]{x, y});
						grid[x][y] = 1;
					}
				}
			}
			res++;
		}
		return -1;
	}
	
}
