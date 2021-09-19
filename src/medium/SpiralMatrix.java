package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static void main(String[] args) {
		List<Integer> res = spiralOrder(new int[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		});
		System.out.println(res);
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				res.add(matrix[rowStart][i]);
			}
			rowStart++;
			
			for (int i = rowStart; i <= rowEnd; i++) {
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					res.add(matrix[rowEnd][i]);
				}
				rowEnd--;
				
			}
			
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					res.add(matrix[i][colStart]);
				}
				colStart++;
			}
		}
		return res;
	}

//	private static void goRight(int[][] matrix, int i, int j, List<Integer> res) {
//		if (!isValid(matrix, i, j)) {
//			return;
//		}
//
//		while (j < matrix[i].length && matrix[i][j] != Integer.MIN_VALUE) {
//			res.add(matrix[i][j]);
//			matrix[i][j] = Integer.MIN_VALUE;
//			j++;
//		}
//		goDown(matrix, i + 1, j - 1, res);
//	}
//
//
//	private static void goDown(int[][] matrix, int i, int j, List<Integer> res) {
//		if (!isValid(matrix, i, j)) {
//			return;
//		}
//
//		while (i < matrix.length && matrix[i][j] != Integer.MIN_VALUE) {
//			res.add(matrix[i][j]);
//			matrix[i][j] = Integer.MIN_VALUE;
//			i++;
//		}
//		goLeft(matrix, i - 1, j - 1, res);
//	}
//
//	private static void goLeft(int[][] matrix, int i, int j, List<Integer> res) {
//		if (!isValid(matrix, i, j)) {
//			return;
//		}
//
//		while (j >= 0 && matrix[i][j] != Integer.MIN_VALUE) {
//			res.add(matrix[i][j]);
//			matrix[i][j] = Integer.MIN_VALUE;
//			j--;
//		}
//		goUp(matrix, i - 1, j + 1, res);
//	}
//
//	private static void goUp(int[][] matrix, int i, int j, List<Integer> res) {
//		if (!isValid(matrix, i, j)) {
//			return;
//		}
//
//		while (i >= 0 && matrix[i][j] != Integer.MIN_VALUE) {
//			res.add(matrix[i][j]);
//			matrix[i][j] = Integer.MIN_VALUE;
//			i--;
//		}
//		goRight(matrix, i + 1, j + 1, res);
//	}
//
//	private static boolean isValid(int[][] matrix, int i, int j) {
//		return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length && matrix[i][j] != Integer.MIN_VALUE;
//	}
}
