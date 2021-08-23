package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	
	public static void main(String[] args) {
		List<Integer> res = largestDivisibleSubset(new int[]{1});
		System.out.println(res);
	}
	
	static public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int[] dp = new int[n];
		int[] prev = new int[n];
		int max = 0;
		int index = -1;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			prev[i] = -1;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
			}
			if (dp[i] > max) {
				max = dp[i];
				index = i;
			}
		}
		
		List<Integer> res = new ArrayList<>();
		while (index != -1) {
			res.add(nums[index]);
			index = prev[index];
		}
		return res;
	}

//	static public List<Integer> largestDivisibleSubset(int[] nums) {
//		Arrays.sort(nums);
//		int n = nums.length;
//		List<Integer>[] dp = new ArrayList[n];
//		for (int i = 0; i < n; i++) {
//			dp[i] = new ArrayList<>();
//		}
//		List<Integer> res = dp[0];
//		for (int i = 0; i < n; i++) {
//			dp[i].add(nums[i]);
//			for (int j = 0; j < i; j++) {
//				if (nums[i] % nums[j] == 0 && dp[i].size() <= dp[j].size()) {
//					dp[i].clear();
//					dp[i].addAll(dp[j]);
//					dp[i].add(nums[i]);
//					if (dp[i].size() > res.size()) {
//						res = dp[i];
//					}
//				}
//			}
//		}
//		return res;
//	}
}
