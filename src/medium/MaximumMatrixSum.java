package medium;

public class MaximumMatrixSum {
	
	public static void main(String[] args) {
		long res = maxMatrixSum(new int[][]{
				{2, 9, 3},
				{5, 4, -4},
				{1, 7, 1},
		});
		System.out.println(res);
	}
	
	public static long maxMatrixSum(int[][] matrix) {
		long res = 0;
		int flipCount = 0;
		int min = Integer.MAX_VALUE;
		for (int[] row : matrix) {
			for (int i : row) {
				if (i <= 0) {
					flipCount++;
				}
				i = Math.abs(i);
				min = Math.min(min, i);
				res += i;
			}
		}
		return flipCount % 2 == 0 ? res : res - min * 2;
	}
}
