package medium;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		NumberOfIslands test = new NumberOfIslands();
		int ans = test.numIslands(new char[][]{
				{'1', '1', '1'},
				{'0', '1', '0'},
				{'1', '1', '1'}
		});
		System.out.println(ans);
		
		ans = test.numIslands(new char[][]{
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		});
		System.out.println(ans);
	}
	
	private int row;
	private int column;
	
	/**
	 * 遇到陸地 總島嶼數就+1
	 * 然後把相鄰的陸地全部變海水 dfs
	 */
	public int numIslands(char[][] grid) {
		int ans = 0;
		row = grid.length;
		if (row == 0)
			return 0;
		column = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '1') {
					ans++;
					dfs(grid, i, j);
				}
			}
		}
		return ans;
	}
	
	private void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == '0')
			return;
		
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
}
