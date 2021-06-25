package medium;

public class OutOfBoundaryPaths {
	
	public static void main(String[] args) {
		int res = findPaths(1, 3, 3, 0, 1);
		System.out.println(res);
	}
	
	final static int MOD = (int) (Math.pow(10, 9) + 7);
	final static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int[][][] memo = new int[m][n][maxMove + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < maxMove + 1; k++) {
					memo[i][j][k] = -1;
				}
			}
		}
		return findPaths(m, n, maxMove, startRow, startColumn, memo) % MOD;
		
	}
	
	private static int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] memo) {
		if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
			return 1;
		}
		if (maxMove == 0) {
			return 0;
		}
		if (memo[startRow][startColumn][maxMove] > -1) {
			return memo[startRow][startColumn][maxMove];
		}
		memo[startRow][startColumn][maxMove] = 0;
		for (int[] dir : DIRECTIONS) {
			int r = startRow + dir[0];
			int c = startColumn + dir[1];
			memo[startRow][startColumn][maxMove] =
					(memo[startRow][startColumn][maxMove] + findPaths(m, n, maxMove - 1, r, c, memo) % MOD) % MOD;
		}
		
		return memo[startRow][startColumn][maxMove];
	}
}
