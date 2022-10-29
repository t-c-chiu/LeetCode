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
			int mid = (lo + hi) / 2, r = mid / n, c = mid % n;
			if (matrix[r][c] == target) {
				return true;
			} else if (matrix[r][c] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return false;
	}
	
}
