package easy;

public class MinCostClimbingStairs {
	
	public static void main(String[] args) {
		int res = minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
		System.out.println(res);
	}
	
	public static int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		for (int i = 2; i < n; i++) {
			cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
		}
		return Math.min(cost[n - 2], cost[n - 1]);
	}
}
