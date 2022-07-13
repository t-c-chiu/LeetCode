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
		int res = 0, m = matrix.length, n = matrix[0].length;
		int[][] memo = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res = Math.max(res, dfs(matrix, i, j, m, n, memo));
			}
		}
		return res;
	}
	
	private static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int max = 0;
		for (int[] dir : dirs) {
			int x = i + dir[0], y = j + dir[1];
			if (x < 0 || x == m || y < 0 || y == n || matrix[x][y] <= matrix[i][j]) {
				continue;
			}
			max = Math.max(max, dfs(matrix, i + dir[0], j + dir[1], m, n, memo));
		}
		memo[i][j] = max + 1;
		return memo[i][j];
	}
//	public static int longestIncreasingPath(int[][] matrix) {
//		int res = 0, m = matrix.length, n = matrix[0].length;
//		int[][] inDegree = new int[m][n];
//		int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				for (int[] dir : dirs) {
//					int x = i + dir[0], y = j + dir[1];
//					if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] < matrix[i][j]) {
//						inDegree[i][j]++;
//					}
//				}
//			}
//		}
//		Queue<int[]> q = new LinkedList<>();
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (inDegree[i][j] == 0) {
//					q.offer(new int[]{i, j});
//				}
//			}
//		}
//		while (!q.isEmpty()) {
//			for (int i = q.size(); i > 0; i--) {
//				int[] cur = q.poll();
//				int curX = cur[0], curY = cur[1];
//				for (int[] dir : dirs) {
//					int newX = curX + dir[0], newY = curY + dir[1];
//					if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[curX][curY]) {
//						if (--inDegree[newX][newY] == 0) {
//							q.offer(new int[]{newX, newY});
//						}
//					}
//				}
//			}
//			res++;
//		}
//		return res;
//	}

}
