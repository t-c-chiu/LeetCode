package medium;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
	
	public static void main(String[] args) {
		int[][] res = highestPeak(new int[][]{
				{0, 0, 1},
				{1, 0, 0},
				{0, 0, 0},
		});
		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] highestPeak(int[][] isWater) {
		int m = isWater.length;
		int n = isWater[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int height[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isWater[i][j] == 1) {
					height[i][j] = 0;
					queue.offer(new int[]{i, j});
				} else {
					height[i][j] = -1;
				}
			}
		}
		
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int r = cell[0];
			int c = cell[1];
			for (int[] dir : dirs) {
				int nr = r + dir[0];
				int nc = c + dir[1];
				if (nr < 0 || nr == m || nc < 0 || nc == n || height[nr][nc] != -1) {
					continue;
				}
				height[nr][nc] = height[r][c] + 1;
				queue.offer(new int[]{nr, nc});
			}
		}
		return height;
	}
}
