package easy;

import java.util.HashSet;
import java.util.Set;

public class DifferenceOfNumberOfDistinctValuesOnDiagonals {
	
	public static void main(String[] args) {
	
	}
	
	public int[][] differenceOfDistinctValues(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = calculate(grid, i, j, m, n);
			}
		}
		return res;
	}
	
	private int calculate(int[][] grid, int i, int j, int m, int n) {
		Set<Integer> left = new HashSet<>();
		Set<Integer> right = new HashSet<>();
		int a = i - 1, b = j - 1;
		while (a >= 0 && b >= 0) {
			left.add(grid[a--][b--]);
		}
		a = i + 1;
		b = j + 1;
		while (a < m && b < n) {
			right.add(grid[a++][b++]);
		}
		return Math.abs(left.size() - right.size());
	}
}
