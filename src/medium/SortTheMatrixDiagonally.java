package medium;

import java.util.*;

public class SortTheMatrixDiagonally {
	
	public static void main(String[] args) {
		int[][] res = diagonalSort(new int[][]{
				{3, 3, 1, 1},
				{2, 2, 1, 2},
				{1, 1, 1, 2}});
		for (int[] row : res) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static int[][] diagonalSort(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int k = i - j;
				map.putIfAbsent(k, new PriorityQueue<>());
				map.get(k).offer(mat[i][j]);
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int k = i - j;
				mat[i][j] = map.get(k).poll();
			}
		}
		return mat;
	}
}
