package medium;

public class TargetSum {
	
	public static void main(String[] args) {
		TargetSum test = new TargetSum();
		int res = test.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
		System.out.println(res);
	}
	
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum < S)
			return 0;
		
		// 總和區間可能為-sum ~ +sum, 這個情況就是-5 ~ +5
		// dp[i] = 總和為 i - sum 的個數, 這裡的i為0 ~ 10
		int n = sum * 2 + 1;
		int[] dp = new int[n];
		dp[+nums[0] + sum]++;
		dp[-nums[0] + sum]++;
		for (int i = 1; i < nums.length; i++) {
			int[] next = new int[n];
			for (int j = -sum; j <= sum; j++) {
				int offset = j + sum;
				if (dp[offset] > 0) {
					next[offset + nums[i]] += dp[offset];
					next[offset - nums[i]] += dp[offset];
				}
			}
			dp = next;
		}
		return dp[S + sum];
	}

//	public int findTargetSumWays(int[] nums, int S) {
//		return dfs(nums, 0, S);
//	}
//
//	private int dfs(int[] nums, int i, int S) {
//		if (i == nums.length)
//			return S == 0 ? 1 : 0;
//		return dfs(nums, i + 1, S + nums[i]) + dfs(nums, i + 1, S - nums[i]);
//	}
}
