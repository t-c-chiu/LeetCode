package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	
	public static void main(String[] args) {
		int[][] res = updateMatrix(new int[][]{
				{1, 1, 1},
				{0, 1, 0},
				{1, 1, 1},
		});
		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] updateMatrix(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int[][] res = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					queue.offer(new int[]{i, j, 0});
					visited[i][j] = true;
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0], y = poll[1], dis = poll[2];
			res[x][y] = dis;
			for (int[] dir : dirs) {
				int nx = x + dir[0], ny = y + dir[1];
				if (nx < 0 || nx == m || ny < 0 || ny == n || visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				queue.offer(new int[]{nx, ny, dis + 1});
			}
		}
		return res;
	}
	
}
