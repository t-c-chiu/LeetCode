package medium;

public class ZeroOneMatrix {
	
	public static void main(String[] args) {
		int[][] res = updateMatrix(new int[][]{
				{1, 1, 1},
				{0, 1, 0},
				{1, 1, 1},
		});
		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] updateMatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 1) {
					mat[i][j] = n * m;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i > 0) {
					mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);
				}
				if (j > 0) {
					mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
				}
			}
		}
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (i < n - 1) {
					mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
				}
				if (j < m - 1) {
					mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
				}
			}
		}
		
		return mat;
	}


//	public static int[][] updateMatrix(int[][] mat) {
//		int n = mat.length;
//		int m = mat[0].length;
//		Queue<int[]> queue = new LinkedList<>();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				if (mat[i][j] == 0) {
//					queue.offer(new int[]{i, j});
//				} else {
//					mat[i][j] = Integer.MAX_VALUE;
//				}
//			}
//		}
//
//		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//		while (!queue.isEmpty()) {
//			int[] cell = queue.poll();
//			for (int[] dir : dirs) {
//				int r = cell[0] + dir[0];
//				int c = cell[1] + dir[1];
//				if (r < 0 || c < 0 || r == n || c == m || mat[r][c] <= mat[cell[0]][cell[1]] + 1) {
//					continue;
//				}
//				mat[r][c] = mat[cell[0]][cell[1]] + 1;
//				queue.offer(new int[]{r, c});
//			}
//
//		}
//		return mat;
//	}
}
