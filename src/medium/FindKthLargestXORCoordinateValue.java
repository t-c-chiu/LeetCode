package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargestXORCoordinateValue {
	
	public static void main(String[] args) {
		int res = kthLargestValue(new int[][]{
				{5, 2},
				{1, 6},
		}, 3);
		System.out.println(res);
	}
	
	public static int kthLargestValue(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int x = i == 0 ? 0 : dp[i - 1][j];
				int y = j == 0 ? 0 : dp[i][j - 1];
				int z = i == 0 || j == 0 ? 0 : dp[i - 1][j - 1];
				dp[i][j] = x ^ y ^ z ^ matrix[i][j];
				pq.offer(dp[i][j]);
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}
		return pq.poll();
	}
}
