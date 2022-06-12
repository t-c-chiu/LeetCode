package easy;

import java.util.Arrays;

public class TransposeMatrix {
	
	public static void main(String[] args) {
		int[][] res = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		Arrays.stream(res).forEach(arr -> {
			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
			System.out.println();
		});
	}
	
	public static int[][] transpose(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] res = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][i] = matrix[i][j];
			}
		}
		return res;
	}
}
