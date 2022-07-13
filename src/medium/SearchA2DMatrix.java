package medium;

public class SearchA2DMatrix {
	
	public static void main(String[] args) {
		boolean res = searchMatrix(new int[][]{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60},
		}, 11);
		System.out.println(res);
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length, lo = 0, hi = m * n - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2, row = mid / n, col = mid % n, num = matrix[row][col];
			if (num == target) {
				return true;
			} else if (num < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return false;
	}
//	public static boolean searchMatrix(int[][] matrix, int target) {
//		int m = matrix.length, n = matrix[0].length;
//		return searchMatrix(matrix, 0, m * n - 1, target, n);
//	}
//
//	/**
//	 * 0 1 2 3 -> 0
//	 * 4 5 6 7 -> 1
//	 * 8 9 10 11 -> 2
//	 * m = 3, n = 4
//	 */
//	private static boolean searchMatrix(int[][] matrix, int lo, int hi, int target, int n) {
//		if (lo > hi) {
//			return false;
//		}
//		int mid = (lo + hi) / 2, row = mid / n, col = mid % n, num = matrix[row][col];
//		if (num == target) {
//			return true;
//		} else if (num < target) {
//			return searchMatrix(matrix, mid + 1, hi, target, n);
//		} else {
//			return searchMatrix(matrix, lo, mid - 1, target, n);
//		}
//	}
}
