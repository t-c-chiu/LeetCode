package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	
	public static void main(String[] args) {
		int res = kthSmallest(new int[][]{
				{1, 5, 9},
				{10, 11, 13},
				{12, 13, 15},
		}, 8);
		System.out.println(res);
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			pq.offer(new int[]{matrix[i][0], i, 0});
		}
		while (k > 1) {
			int[] cur = pq.poll();
			int y = cur[2];
			if (y + 1 < n) {
				int x = cur[1];
				pq.offer(new int[]{matrix[x][y + 1], x, y + 1});
			}
			k--;
		}
		return pq.peek()[0];
	}
	
}
