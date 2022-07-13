package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
	
	public static void main(String[] args) {
		int res = minKnightMoves(5, 5);
		System.out.println(res);
	}
	
	public static int minKnightMoves(int x, int y) {
		x = Math.abs(x);
		y = Math.abs(y);
		int[][] dirs = new int[][]{{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
		Queue<int[]> q = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		q.offer(new int[]{0, 0});
		seen.add("0,0");
		int res = 0;
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				int[] cur = q.poll();
				int curX = cur[0], curY = cur[1];
				if (curX == x && curY == y) {
					return res;
				}
				for (int[] dir : dirs) {
					int newX = curX + dir[0];
					int newY = curY + dir[1];
					if (newX >= -1 && newY >= -1 && !seen.contains(newX + "," + newY)) {
						seen.add(newX + "," + newY);
						q.offer(new int[]{newX, newY});
					}
				}
			}
			res++;
		}
		return res;
	}
}
