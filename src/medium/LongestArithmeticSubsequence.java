package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
	
	public static void main(String[] args) {
		int res = longestArithSeqLength(new int[]{3, 6, 9, 12});
		System.out.println(res);
	}
	
	public static int longestArithSeqLength(int[] nums) {
		int n = nums.length, res = 0;
		Map<Integer, Integer>[] dp = new Map[n];
		for (int i = 0; i < n; i++) {
			dp[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				int diff = nums[i] - nums[j];
				dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
				res = Math.max(res, dp[i].get(diff));
			}
		}
		return res;
	}
}
