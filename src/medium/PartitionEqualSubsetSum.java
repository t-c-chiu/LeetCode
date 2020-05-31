package medium;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
		System.out.println(test.canPartition(new int[]{1, 5, 11, 5}));
	}
	
	// 這題的問題是, nums中有沒有subset的總和是sum/2
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 2 == 1)
			return false;
		sum /= 2;
		// dp[i] = nums中是否存在subset使其和為i
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = sum; i >= num; i--) {
				dp[i] = dp[i] || dp[i - num];
			}
		}
		return dp[sum];
	}
}
