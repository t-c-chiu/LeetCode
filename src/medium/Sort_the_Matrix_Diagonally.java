package medium;

import java.util.*;

public class Sort_the_Matrix_Diagonally {
	
	public static void main(String[] args) {
		Sort_the_Matrix_Diagonally test = new Sort_the_Matrix_Diagonally();
		int[][] res = test.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}});
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j]);
			}
		}
	}
	
	/**
	 * 3 3 1 1   1 1 1 1
	 * 2 2 1 2   1 2 2 2
	 * 1 1 1 2   1 2 3 3
	 */
	public int[][] diagonalSort(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int k = i - j;
				map.putIfAbsent(k, new PriorityQueue<>());
				map.get(k).add(mat[i][j]);
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = map.get(i - j).poll();
			}
		}
		return mat;
	}
}
