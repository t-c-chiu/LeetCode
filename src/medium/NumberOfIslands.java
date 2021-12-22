package medium;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		int ans = numIslands(new char[][]{
				{'1', '1', '1'},
				{'0', '1', '0'},
				{'1', '1', '1'}
		});
		System.out.println(ans);
		
		ans = numIslands(new char[][]{
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		});
		System.out.println(ans);
	}
	
	
	public static int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					res++;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}
	
	private static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
			return;
		}
		
		grid[i][j] = '0';
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			dfs(grid, i + dir[0], j + dir[1]);
		}
	}
}
