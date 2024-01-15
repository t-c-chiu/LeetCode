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
		int m = mat.length, n = mat[0].length;
		int[] res = new int[m * n];
		for (int i = 0, r = 0, c = 0; i < res.length; i++) {
			res[i] = mat[r][c];
			if ((r + c) % 2 == 0) {
				if (c == n - 1) {
					r++;
				} else if (r == 0) {
					c++;
				} else {
					r--;
					c++;
				}
			} else {
				if (r == m - 1) {
					c++;
				} else if (c == 0) {
					r++;
				} else {
					r++;
					c--;
				}
			}
		}
		return res;
	}
}
