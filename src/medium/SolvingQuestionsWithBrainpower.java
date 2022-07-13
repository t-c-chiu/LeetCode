package medium;

public class SolvingQuestionsWithBrainpower {
	
	public static void main(String[] args) {
		long res = mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}});
		System.out.println(res);
	}
	
	public static long mostPoints(int[][] questions) {
		int n = questions.length;
		long[] dp = new long[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = Math.max(dp[i + 1], questions[i][0]);
			if (i + questions[i][1] + 1 < n) {
				dp[i] = Math.max(dp[i], questions[i][0] + dp[i + questions[i][1] + 1]);
			}
		}
		return dp[0];
	}
}
