package medium;

public class CheckIfThereIsAValidPartitionForTheArray {
	
	public static void main(String[] args) {
		boolean res = validPartition(new int[]{993335, 993336, 993337, 993338, 993339, 993340, 993341});
		System.out.println(res);
	}
	
	public static boolean validPartition(int[] nums) {
		int n = nums.length;
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 2; i <= n; i++) {
			int cur = nums[i - 1], prev = nums[i - 2];
			dp[i] = dp[i - 2] && cur == prev || i > 2 && dp[i - 3] && (cur == prev && cur == nums[i - 3] || cur - prev == 1 && prev - nums[i - 3] == 1);
		}
		return dp[n];
	}
}
