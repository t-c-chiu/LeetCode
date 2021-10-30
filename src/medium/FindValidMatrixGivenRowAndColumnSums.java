package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindValidMatrixGivenRowAndColumnSums {
	
	public static void main(String[] args) {
		int[][] res = restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8});
		for (int[] arr : res) {
			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
			System.out.println();
		}
	}
	
	public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int m = rowSum.length, n = colSum.length;
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = Math.min(rowSum[i], colSum[j]);
				rowSum[i] -= res[i][j];
				colSum[j] -= res[i][j];
			}
		}
		return res;
	}
//	public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
//		int m = rowSum.length, n = colSum.length;
//		Comparator<int[]> comparator = Comparator.comparingInt(o -> o[0]);
//		PriorityQueue<int[]> rows = new PriorityQueue<>(comparator);
//		PriorityQueue<int[]> cols = new PriorityQueue<>(comparator);
//		for (int i = 0; i < m; i++) {
//			if (rowSum[i] > 0) {
//				rows.offer(new int[]{rowSum[i], i});
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			if (colSum[i] > 0) {
//				cols.offer(new int[]{colSum[i], i});
//			}
//		}
//
//		int[][] res = new int[m][n];
//		while (!rows.isEmpty() && !cols.isEmpty()) {
//			int[] row = rows.poll();
//			int[] col = cols.poll();
//			int sub = Math.min(row[0], col[0]);
//			res[row[1]][col[1]] = sub;
//			row[0] -= sub;
//			col[0] -= sub;
//			if (row[0] > 0) {
//				rows.offer(row);
//			}
//			if (col[0] > 0) {
//				cols.offer(col);
//			}
//		}
//		return res;
//	}
}
