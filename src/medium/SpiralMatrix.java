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
		int m = matrix.length, n = matrix[0].length, rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
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
	
}
