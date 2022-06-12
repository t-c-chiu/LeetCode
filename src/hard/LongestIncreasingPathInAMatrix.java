package hard;

public class LongestIncreasingPathInAMatrix {
	
	public static void main(String[] args) {
		int res = longestIncreasingPath(new int[][]{
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}});
		System.out.println(res);
	}
	
	public static int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length, res = 0;
		int[][] cache = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res = Math.max(res, dfs(matrix, i, j, m, n, cache));
			}
		}
		return res;
	}
	
	private static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
		if (cache[i][j] != 0) {
			return cache[i][j];
		}
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int res = 1;
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				res = Math.max(res, 1 + dfs(matrix, x, y, m, n, cache));
			}
		}
		cache[i][j] = res;
		return res;
	}
}
