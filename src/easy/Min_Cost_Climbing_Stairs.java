package easy;

public class Min_Cost_Climbing_Stairs {
	
	public static void main(String[] args) {
		Min_Cost_Climbing_Stairs test = new Min_Cost_Climbing_Stairs();
		System.out.println(test.minCostClimbingStairs2(new int[]{10, 15, 20}));
		System.out.println(test.minCostClimbingStairs2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}
	
	public int minCostClimbingStairs(int[] cost) {
		int len = cost.length;
		// dp[i] = 到i階至少需要的cost
		int[] dp = new int[len];
		for (int i = 2; i < len; i++) {
			dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
		}
		return Math.min(dp[len - 1] + cost[len - 1], dp[len - 2] + cost[len - 2]);
	}
	
	public int minCostClimbingStairs2(int[] cost) {
		// cost[i] = 從i階往上爬最少需要的cost
		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}
		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}
}
