package medium;

import java.util.Arrays;

public class SpiralMatrixII {
	
	public static void main(String[] args) {
		int[][] res = generateMatrix(4);
		Arrays.stream(res).forEach(arr -> {
			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
			System.out.println();
		});
	}
	
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int num = 1, rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
		while (num <= n * n) {
			for (int i = colStart; i <= colEnd; i++) {
				res[rowStart][i] = num++;
			}
			rowStart++;
			
			for (int i = rowStart; i <= rowEnd; i++) {
				res[i][colEnd] = num++;
			}
			colEnd--;
			
			for (int i = colEnd; i >= colStart; i--) {
				res[rowEnd][i] = num++;
			}
			rowEnd--;
			
			for (int i = rowEnd; i >= rowStart; i--) {
				res[i][colStart] = num++;
			}
			colStart++;
		}
		return res;
	}
}
