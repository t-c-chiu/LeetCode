package medium;

import java.util.Arrays;

public class DiagonalTraverse {
	
	public static void main(String[] args) {
		int[] res = findDiagonalOrder(new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] findDiagonalOrder(int[][] mat) {
		int m = mat.length, n = mat[0].length, i = 0, j = 0, k = 0;
		int[] res = new int[m * n];
		while (k < m * n) {
			while (i >= 0 && j < n) {
				res[k++] = mat[i][j];
				i--;
				j++;
			}
			i++;
			j--;
			if (j + 1 < n) {
				j++;
			} else {
				i++;
			}
			while (i < m && j >= 0) {
				res[k++] = mat[i][j];
				i++;
				j--;
			}
			i--;
			j++;
			if (i + 1 < m) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
}
