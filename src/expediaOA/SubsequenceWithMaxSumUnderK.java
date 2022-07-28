package expediaOA;

public class SubsequenceWithMaxSumUnderK {
	
	public static void main(String[] args) {
		int res = solution(new int[]{1, 2, 3, 12, 3}, 10);
		System.out.println(res);
	}
	
	static int solution(int[] nums, int k) {
		int n = nums.length;
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j];
				int num = nums[i - 1];
				if (num <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - num] + num);
				}
			}
		}
		return dp[n][k];
	}
}
