package medium;

public class SearchA2DMatrixII {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(matrix, 20));
		System.out.println(searchMatrix(matrix, 16));
		System.out.println(searchMatrix(matrix, 31));
		System.out.println(searchMatrix(matrix, 0));
		System.out.println(searchMatrix(matrix, 12));
		System.out.println(searchMatrix(matrix, 13));
		System.out.println(searchMatrix(matrix, 24));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length - 1, col = 0;
		while (row >= 0 && col < matrix[0].length) {
			int num = matrix[row][col];
			if (num == target) {
				return true;
			} else if (num < target) {
				col++;
			} else {
				row--;
			}
		}
		return false;
	}
}
