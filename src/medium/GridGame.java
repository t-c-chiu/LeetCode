package medium;

public class GridGame {
	
	public static void main(String[] args) {
		long res = gridGame(new int[][]{
				{1, 3, 1, 15},
				{1, 3, 3, 1}
		});
		System.out.println(res);
	}
	
	/**
	 * Math.max(res - grid[0][j], r2sum) is the max point second robot can get if first robot goes down at grid[0][j]
	 * but we need to minimize it so res = Math.min(res, Math.max(res - grid[0][j], r2sum))
	 */
	public static long gridGame(int[][] grid) {
		int n = grid[0].length;
		long res = 0;
		for (int j = 0; j < n; j++) {
			res += grid[0][j];
		}
		long r2sum = 0;
		for (int j = 0; j < n; j++) {
			res = Math.min(res, Math.max(res - grid[0][j], r2sum));
			r2sum += grid[1][j];
		}
		return res;
	}
	
}
