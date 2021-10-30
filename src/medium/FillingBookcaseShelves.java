package medium;

public class FillingBookcaseShelves {
	
	public static void main(String[] args) {
		int res = minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4);
		System.out.println(res);
	}
	
	public static int minHeightShelves(int[][] books, int shelfWidth) {
		int n = books.length;
		int[] dp = new int[n + 1];
		for (int i = 1; i <= books.length; i++) {
			int width = books[i - 1][0], height = books[i - 1][1];
			dp[i] = dp[i - 1] + height;
			for (int j = i - 1; j > 0 && books[j - 1][0] + width <= shelfWidth; j--) {
				height = Math.max(height, books[j - 1][1]);
				width += books[j - 1][0];
				dp[i] = Math.min(dp[i], dp[j - 1] + height);
			}
		}
		return dp[n];
	}
}
