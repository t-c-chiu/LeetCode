package medium;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
	
	public static void main(String[] args) {
		int res = maxDistance(new int[][]{
				{1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
				{1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
				{0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
				{1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
				{0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
				{0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
				{0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
				{1, 1, 0, 1, 1, 1, 1, 1, 0, 0}}
		);
		System.out.println(res);
	}
	
	public static int maxDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length, res = -1;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[]{i, j});
				}
			}
		}
		if (queue.isEmpty() || queue.size() == m * n) {
			return -1;
		}
		while (!queue.isEmpty()) {
			res++;
			for (int i = queue.size(); i > 0; i--) {
				int[] poll = queue.poll();
				int x = poll[0], y = poll[1];
				for (int[] dir : dirs) {
					int newX = x + dir[0];
					int newY = y + dir[1];
					if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0) {
						queue.offer(new int[]{newX, newY});
						grid[newX][newY] = 1;
					}
				}
			}
		}
		return res;
	}
}
