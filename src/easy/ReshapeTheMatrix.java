package easy;

import java.util.LinkedList;
import java.util.Queue;

public class ReshapeTheMatrix {
	
	public static void main(String[] args) {
		int[][] res = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] matrixReshape(int[][] mat, int r, int c) {
		int n = mat.length;
		int m = mat[0].length;
		if (n * m != r * c) {
			return mat;
		}
		
		int[][] res = new int[r][c];
		for (int i = 0; i < n * m; i++) {
			res[i / c][i % c] = mat[i / m][i % m];
		}
		return res;
	}
}
