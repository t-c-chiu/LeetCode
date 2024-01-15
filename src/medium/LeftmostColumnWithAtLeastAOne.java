package medium;

import java.util.Arrays;
import java.util.List;

public class LeftmostColumnWithAtLeastAOne {
	
	public static void main(String[] args) {
		int res = leftMostColumnWithOne(new BinaryMatrix());
		System.out.println(res);
	}
	
	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int m = dimensions.get(0), n = dimensions.get(1), res = n;
		for (int i = 0; i < m; i++) {
			res = Math.min(res, binarySearch(binaryMatrix, i));
		}
		return res == n ? -1 : res;
	}
	
	private static int binarySearch(BinaryMatrix binaryMatrix, int row) {
		int lo = 0, hi = binaryMatrix.dimensions().get(1);
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (binaryMatrix.get(row, mid) == 0) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
	
	static class BinaryMatrix {
		int[][] matrix = new int[][]{
				{0, 0, 1, 1},
				{0, 0, 0, 1},
				{0, 1, 1, 1}
		};
		
		int get(int row, int col) {
			return matrix[row][col];
		}
		
		List<Integer> dimensions() {
			return Arrays.asList(matrix.length, matrix[0].length);
		}
	}
}
