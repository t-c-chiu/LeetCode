package medium;

public class Perfect_Squares {
	
	public static void main(String[] args) {
		Perfect_Squares test = new Perfect_Squares();
		System.out.println(test.numSquares(12));// 4 4 4
		System.out.println(test.numSquares(13));// 4 9
		System.out.println(test.numSquares(18));// 9 9
	}
	
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++)
			dp[i] = Integer.MAX_VALUE;
		for (int i = 0; i * i <= n; i++)
			dp[i * i] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; i + j * j <= n; j++) {
				dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
			}
		}
		return dp[n];
	}
}
