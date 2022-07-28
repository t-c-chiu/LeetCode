package easy;

public class MinCostClimbingStairs {
	
	public static void main(String[] args) {
		int res = minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
		System.out.println(res);
	}
	
	public static int minCostClimbingStairs(int[] cost) {
		int prev = cost[0], cur = cost[1];
		for (int i = 2; i < cost.length; i++) {
			int temp = Math.min(prev, cur) + cost[i];
			prev = cur;
			cur = temp;
		}
		return Math.min(prev, cur);
	}

//	public static int minCostClimbingStairs(int[] cost) {
//		int n = cost.length;
//		int[] dp = new int[n];
//		dp[0] = cost[0];
//		dp[1] = cost[1];
//		for (int i = 2; i < n; i++) {
//			dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
//		}
//		return Math.min(dp[n - 2], dp[n - 1]);
//	}
}
