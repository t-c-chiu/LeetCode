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
		int rows = dimensions.get(0);
		int cols = dimensions.get(1);
		int curRow = 0;
		int curCol = cols - 1;
		while (curRow < rows && curCol >= 0) {
			int value = binaryMatrix.get(curRow, curCol);
			if (value == 1) {
				curCol--;
			} else {
				curRow++;
			}
		}
		return curCol == cols - 1 ? -1 : curCol + 1;
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
