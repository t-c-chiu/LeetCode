package medium;

public class SearchA2DMatrix {
	
	public static void main(String[] args) {
		boolean res = searchMatrix(new int[][]{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60},
		}, 17);
		System.out.println(res);
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int left = 0;
		int right = n * m - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int v = matrix[mid / m][mid % m];
			if (v == target) {
				return true;
			} else if (v < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
