package medium;

public class CyclicallyRotatingAGrid {
	
	public static void main(String[] args) {
		int[][] res = rotateGrid(new int[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
		}, 2);
		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] rotateGrid(int[][] grid, int k) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] res = new int[n][m];
		int left = 0;
		int right = m - 1;
		int top = 0;
		int bottom = n - 1;
		while (left < right && top < bottom) {
			int total = ((right - left + 1) * 2 + (bottom - top - 1) * 2);
			rotate(res, grid, left, right, top, bottom, k % total);
			left++;
			right--;
			top++;
			bottom--;
		}
		return res;
	}
	
	private static void rotate(int[][] res, int[][] grid, int left, int right, int top, int bottom, int k) {
		for (int i = left; i < right; i++) {
			res[top][i] = searchTop(grid, left, right, top, bottom, i + k);
		}
		for (int i = top; i < bottom; i++) {
			res[i][right] = searchRight(grid, left, right, top, bottom, i + k);
		}
		for (int i = right; i > left; i--) {
			res[bottom][i] = searchBottom(grid, left, right, top, bottom, i - k);
		}
		for (int i = bottom; i > top; i--) {
			res[i][left] = searchLeft(grid, left, right, top, bottom, i - k);
		}
	}
	
	private static int searchTop(int[][] grid, int left, int right, int top, int bottom, int i) {
		if (i > right) {
			return searchRight(grid, left, right, top, bottom, top + i - right);
		}
		return grid[top][i];
	}
	
	private static int searchRight(int[][] grid, int left, int right, int top, int bottom, int i) {
		if (i > bottom) {
			return searchBottom(grid, left, right, top, bottom, right - (i - bottom));
		}
		return grid[i][right];
	}
	
	private static int searchBottom(int[][] grid, int left, int right, int top, int bottom, int i) {
		if (i < left) {
			return searchLeft(grid, left, right, top, bottom, bottom - (left - i));
		}
		return grid[bottom][i];
	}
	
	private static int searchLeft(int[][] grid, int left, int right, int top, int bottom, int i) {
		if (i < top) {
			return searchTop(grid, left, right, top, bottom, left + top - i);
		}
		return grid[i][left];
	}
	
}
