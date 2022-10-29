package easy;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
	
	public static void main(String[] args) {
		int[] res = answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] answerQueries(int[] nums, int[] queries) {
		Arrays.sort(nums);
		int n = nums.length, m = queries.length;
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += nums[j];
				if (sum <= queries[i]) {
					res[i] = j + 1;
				} else {
					break;
				}
			}
		}
		return res;
	}
}
