package medium;

import java.util.HashMap;
import java.util.Map;

public class MaxIncreaseToKeepCitySkyline {
	public static void main(String[] args) {
		System.out.println(new MaxIncreaseToKeepCitySkyline().maxIncreaseKeepingSkyline(new int[][]{
				{3, 0, 8, 4},
				{2, 4, 5, 7},
				{9, 2, 6, 3},
				{0, 3, 1, 0}
		}));
	}
	
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int sum = 0, rowNum = grid.length, colNum = grid[0].length;
		int[] rowmax = new int[rowNum],
				colmax = new int[colNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				int height = grid[i][j];
				rowmax[i] = Math.max(rowmax[i], height);
				colmax[j] = Math.max(colmax[j], height);
			}
		}
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				sum += Math.min(rowmax[i], colmax[j]) - grid[i][j];
			}
		}
		return sum;
	}
	
	private Map<String, Integer> cache = new HashMap<>();
	
	public int maxIncreaseKeepingSkyline2(int[][] grid) {
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int restriction = getRestriction(grid, i, j);
				sum += restriction - grid[i][j];
			}
		}
		return sum;
	}
	
	private int getRestriction(int[][] grid, int row, int column) {
		String coordinate = row + "-" + column;
		if (cache.containsKey(coordinate))
			return cache.get(coordinate);
		int restriction = Math.min(getRowsHighest(grid, row), getColumnsHighest(grid, column));
		cache.put(coordinate, restriction);
		return restriction;
	}
	
	private int getRowsHighest(int[][] grid, int row) {
		int max = 0;
		for (int i = 0; i < grid[row].length; i++)
			max = Math.max(max, grid[row][i]);
		return max;
	}
	
	private int getColumnsHighest(int[][] grid, int column) {
		int max = 0;
		for (int i = 0; i < grid.length; i++)
			max = Math.max(max, grid[i][column]);
		return max;
	}
}