package medium;

import java.util.Arrays;

public class RotatingTheBox {
	
	public static void main(String[] args) {
		char[][] res = rotateTheBox(new char[][]{
				{'#', '#', '*', '.', '*', '.' },
				{'#', '#', '#', '*', '.', '.' },
				{'#', '#', '#', '.', '#', '.' }});
		Arrays.stream(res).forEach(chars -> {
			for (char c : chars) {
				System.out.print(c + " ");
			}
			System.out.println();
		});
	}
	
	public static char[][] rotateTheBox(char[][] box) {
		int m = box.length, n = box[0].length;
		// shift
		for (int i = 0; i < m; i++) {
			int pos = n - 1;
			for (int j = n - 1; j >= 0; j--) {
				if (box[i][j] == '#') {
					box[i][pos--] = '#';
				} else if (box[i][j] == '*') {
					while (pos > j) {
						box[i][pos--] = '.';
					}
					pos--;
				}
			}
			while (pos >= 0) {
				box[i][pos--] = '.';
			}
		}
		// rotate
		char[][] res = new char[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][m - i - 1] = box[i][j];
			}
		}
		return res;
	}
}
