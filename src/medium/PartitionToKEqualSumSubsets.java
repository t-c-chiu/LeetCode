package medium;

public class PartitionToKEqualSumSubsets {
	
	public static void main(String[] args) {
		boolean res = canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
		System.out.println(res);
	}
	
	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		return dfs(nums, 0, 0, sum / k, k, new boolean[nums.length]);
	}
	
	private static boolean dfs(int[] nums, int start, int sum, int target, int round, boolean[] visited) {
		if (round == 0) {
			return true;
		}
		if (sum == target) {
			return dfs(nums, 0, 0, target, round - 1, visited);
		}
		for (int i = start; i < nums.length; i++) {
			if (visited[i] || sum + nums[i] > target) {
				continue;
			}
			visited[i] = true;
			if (dfs(nums, i + 1, sum + nums[i], target, round, visited)) {
				return true;
			}
			visited[i] = false;
		}
		return false;
	}
}
