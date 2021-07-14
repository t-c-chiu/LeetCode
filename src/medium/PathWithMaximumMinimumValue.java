package medium;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {
	
	public static void main(String[] args) {
		int res = maximumMinimumPath(new int[][]{
				{3, 4, 6, 3, 4},
				{0, 2, 1, 1, 7},
				{8, 8, 3, 2, 7},
				{3, 2, 4, 9, 8},
				{4, 1, 2, 0, 0},
				{4, 6, 5, 4, 3},
		});
		System.out.println(res);
	}
	
	
	public static int maximumMinimumPath(int[][] grid) {
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
		queue.offer(new int[]{0, 0, grid[0][0]});
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int row = cell[0];
			int col = cell[1];
			if (row == n - 1 && col == m - 1) {
				return cell[2];
			}
			
			visited[row][col] = true;
			for (int[] dir : dirs) {
				int nextRow = row + dir[0];
				int nextCol = col + dir[1];
				if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == m || visited[nextRow][nextCol]) {
					continue;
				}
				queue.offer(new int[]{nextRow, nextCol, Math.min(cell[2], grid[nextRow][nextCol])});
			}
		}
		return -1;
	}
	
}
