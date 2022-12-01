package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
	
	public static void main(String[] args) {
		int res = swimInWater(new int[][]{
				{0, 1, 2, 3, 4},
				{24, 23, 22, 21, 5},
				{12, 13, 14, 15, 16},
				{11, 17, 18, 19, 20},
				{10, 9, 8, 7, 6}});
		System.out.println(res);
	}
	
	public static int swimInWater(int[][] grid) {
		int n = grid.length, res = 0;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
		pq.offer(new int[]{0, 0});
		boolean[][] seen = new boolean[n][n];
		seen[0][0] = true;
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int x = poll[0], y = poll[1];
			res = Math.max(res, grid[x][y]);
			if (x == n - 1 && y == n - 1) {
				return res;
			}
			for (int[] dir : dirs) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				if (nx < 0 || nx == n || ny < 0 || ny == n || seen[nx][ny]) {
					continue;
				}
				seen[nx][ny] = true;
				pq.offer(new int[]{nx, ny});
			}
		}
		return res;
	}
}
