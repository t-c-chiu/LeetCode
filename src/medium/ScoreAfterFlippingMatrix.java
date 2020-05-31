package medium;

public class ScoreAfterFlippingMatrix {
	
	public static void main(String[] args) {
		ScoreAfterFlippingMatrix test = new ScoreAfterFlippingMatrix();
		int matrixScore = test.matrixScore(new int[][]{
				{0, 0, 1, 1},
				{1, 0, 1, 0},
				{1, 1, 0, 0}});
		System.out.println(matrixScore);
	}
	
	/**
	 * 二進位要最大第一個位置一定是1
	 * 所以先檢查first column的數字 如果是0 就翻轉那row 讓first column全變1
	 * 然後再檢查每個column是否需要翻轉 順便紀錄1的個數
	 *
	 * 0 0 1 1    1 1 0 0    1 1 1 0    1 1 1 1
	 * 1 0 1 0 -> 1 0 1 0 -> 1 0 0 0 -> 1 0 0 1
	 * 1 1 0 0    1 1 0 0    1 1 1 0    1 1 1 1
	 */
	public int matrixScore(int[][] A) {
		int m = A.length, n = A[0].length, sum = 0;
		for (int i = 0; i < m; i++) {
			int[] row = A[i];
			if (row[0] == 0) {
				for (int j = 0; j < n; j++) {
					row[j] = row[j] == 0 ? 1 : 0;
				}
			}
		}
		
		// ones存已經翻轉過後的每個column 1的個數
		int[] ones = new int[n];
		for (int i = 0; i < n; i++) {
			int oneCount = 0;
			for (int j = 0; j < m; j++) {
				if (A[j][i] == 1)
					oneCount++;
			}
			ones[i] = Math.max(oneCount, m - oneCount);
		}
		
		for (int i = 0; i < ones.length; i++) {
			sum += ones[i] * Math.pow(2, ones.length - i - 1);
		}
		return sum;
	}
}
