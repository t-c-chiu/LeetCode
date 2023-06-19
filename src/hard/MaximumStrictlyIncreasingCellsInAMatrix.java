package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaximumStrictlyIncreasingCellsInAMatrix {
	
	public static void main(String[] args) {
		int res = maxIncreasingCells(new int[][]{
				{3, 1, 6},
				{-9, 5, 7}});
		System.out.println(res);
	}
	
	public static int maxIncreasingCells(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		Map<Integer, List<int[]>> map = new TreeMap<>();
		int[][] dp = new int[m][n];
		int[] r = new int[m];
		int[] c = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int v = mat[i][j];
				map.putIfAbsent(v, new ArrayList<>());
				map.get(v).add(new int[]{i, j});
			}
		}
		int res = 0;
		for (Integer v : map.keySet()) {
			for (int[] ij : map.get(v)) {
				int i = ij[0], j = ij[1];
				dp[i][j] = Math.max(r[i], c[j]) + 1;
				res = Math.max(res, dp[i][j]);
			}
			for (int[] ij : map.get(v)) {
				int i = ij[0], j = ij[1];
				r[i] = Math.max(r[i], dp[i][j]);
				c[j] = Math.max(c[j], dp[i][j]);
			}
		}
		return res;
	}
	
	
}
