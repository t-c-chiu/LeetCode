package medium;

public class FillingBookcaseShelves {
	
	public static void main(String[] args) {
		int res = minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4);
		System.out.println(res);
	}
	
	public static int minHeightShelves(int[][] books, int shelfWidth) {
		int n = books.length;
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int[] book = books[i - 1];
			int width = book[0], height = book[1];
			dp[i] = dp[i - 1] + height;
			for (int j = i - 1; j > 0; j--) {
				int[] curBook = books[j - 1];
				width += curBook[0];
				height = Math.max(height, curBook[1]);
				if (width > shelfWidth) {
					break;
				}
				dp[i] = Math.min(dp[i], dp[j - 1] + height);
			}
		}
		return dp[n];
	}
}
