package medium;

public class SearchA2DMatrixII {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
//		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 5));
		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 20));
		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 16));
		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 31));
		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 0));
		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 12));
		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 13));
		System.out.println(searchA2DMatrixII.searchMatrix(matrix, 24));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			int num = matrix[row][col];
			if (num == target)
				return true;
			if (num > target)
				col--;
			else
				row++;
		}
		return false;
	}
}
