package medium;

import java.util.*;

public class QueensThatCanAttackTheKing {
	
	public static void main(String[] args) {
		QueensThatCanAttackTheKing test = new QueensThatCanAttackTheKing();
		final List<List<Integer>> res =
				test.queensAttacktheKing(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}},
						new int[]{3, 3});
		System.out.println(res);
	}
	
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[][] seen = new boolean[8][8];
		for (int[] queen : queens)
			seen[queen[0]][queen[1]] = true;
		int[] direction = new int[]{-1, 0, 1};
		for (int dirX : direction) {
			for (int dirY : direction) {
				if (dirX == 0 && dirY == 0)
					continue;
				int x = king[0] + dirX, y = king[1] + dirY;
				while (x >= 0 && x < 8 && y >= 0 && y < 8) {
					if (seen[x][y]) {
						res.add(Arrays.asList(x, y));
						break;
					}
					x += dirX;
					y += dirY;
				}
			}
		}
		return res;
	}
}
