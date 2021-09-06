package medium;

public class BombEnemy {
	
	public static void main(String[] args) {
		int res = maxKilledEnemies(new char[][]{
				{'0', 'E', '0', '0'},
				{'E', '0', 'W', 'E'},
				{'0', 'E', '0', '0'},
		});
		System.out.println(res);
	}
	
	public static int maxKilledEnemies(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		int[][] kill = new int[m][n];
		for (int i = 0; i < m; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				count = countKill(kill, grid, i, j, count);
			}
			count = 0;
			for (int j = n - 1; j >= 0; j--) {
				count = countKill(kill, grid, i, j, count);
			}
		}
		for (int j = 0; j < n; j++) {
			int count = 0;
			for (int i = 0; i < m; i++) {
				count = countKill(kill, grid, i, j, count);
			}
			count = 0;
			for (int i = m - 1; i >= 0; i--) {
				count = countKill(kill, grid, i, j, count);
				max = Math.max(max, kill[i][j]);
			}
		}
		return max;
	}
	
	private static int countKill(int[][] kill, char[][] grid, int i, int j, int count) {
		switch (grid[i][j]) {
			case 'E':
				return count + 1;
			case 'W':
				return 0;
			default:
				kill[i][j] += count;
				return count;
		}
	}
}
