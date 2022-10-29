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
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int i = poll[0], j = poll[1], dis = poll[2];
			mat[i][j] = dis;
			for (int[] dir : dirs) {
				int r = i + dir[0], c = j + dir[1];
				if (r < 0 || r == m || c < 0 || c == n || visited[r][c]) {
					continue;
				}
				visited[r][c] = true;
				queue.offer(new int[]{r, c, dis + 1});
			}
		}
		return mat;
	}
	
}
