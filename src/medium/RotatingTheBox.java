package medium;

import java.util.Arrays;

public class RotatingTheBox {
	
	public static void main(String[] args) {
		char[][] res = rotateTheBox(new char[][]{
				{'#', '#', '*', '.', '*', '.'},
				{'#', '#', '#', '*', '.', '.'},
				{'#', '#', '#', '.', '#', '.'}});
		Arrays.stream(res).forEach(row -> System.out.println(Arrays.toString(row)));
	}
	
	public static char[][] rotateTheBox(char[][] box) {
		int m = box.length, n = box[0].length;
		for (char[] row : box) {
			toRight(row);
		}
		char[][] res = new char[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][m - i - 1] = box[i][j];
			}
		}
		return res;
	}
	
	private static void toRight(char[] row) {
		int n = row.length, empty = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			int cell = row[i];
			if (cell == '*') {
				empty = i - 1;
			}
			if (cell == '#') {
				row[i] = '.';
				row[empty] = '#';
				empty--;
			}
		}
	}
	
}
