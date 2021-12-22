package medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
	
	public static void main(String[] args) {
		int[][] rooms = new int[][]{
				{2147483647, -1, 0, 2147483647},
				{2147483647, 2147483647, 2147483647, -1},
				{2147483647, -1, 2147483647, -1},
				{0, -1, 2147483647, 2147483647}};
		wallsAndGates(rooms);
		for (int[] room : rooms) {
			for (int i : room) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static void wallsAndGates(int[][] rooms) {
		int m = rooms.length, n = rooms[0].length;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					queue.offer(new int[]{i, j, 0});
				}
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				for (int[] dir : dirs) {
					int x = poll[0] + dir[0];
					int y = poll[1] + dir[1];
					if (x < 0 || x == m || y < 0 || y == n || rooms[x][y] != Integer.MAX_VALUE) {
						continue;
					}
					rooms[x][y] = poll[2] + 1;
					queue.offer(new int[]{x, y, rooms[x][y]});
				}
			}
		}
	}
}
