package medium;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
	
	public static void main(String[] args) {
		int res = snakesAndLadders(new int[][]{
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 35, -1, -1, 13, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 15, -1, -1, -1, -1}}
		);
		System.out.println(res);
	}
	
	public static int snakesAndLadders(int[][] board) {
		int res = 0, n = board.length;
		boolean[] visited = new boolean[n * n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int num = queue.poll();
				if (visited[num]) {
					continue;
				}
				visited[num] = true;
				if (num == n * n) {
					return res;
				}
				for (int next = num + 1; next <= Math.min(num + 6, n * n); next++) {
					int value = getBoardValue(board, next);
					if (value == -1) {
						value = next;
					}
					if (!visited[value]) {
						queue.offer(value);
					}
				}
			}
			res++;
		}
		return -1;
	}
	
	private static int getBoardValue(int[][] board, int num) {
		int n = board.length;
		int oldRow = (num - 1) / n;
		int r = n - 1 - oldRow;
		int oldCol = (num - 1) % n;
		int c = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;
		return board[r][c];
	}
}
