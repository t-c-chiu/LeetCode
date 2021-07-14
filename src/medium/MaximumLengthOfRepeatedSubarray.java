package medium;

public class MaximumLengthOfRepeatedSubarray {
	
	public static void main(String[] args) {
		int res = findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
		System.out.println(res);
	}
	
	public static int findLength(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int[][] dp = new int[n][m];
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nums1[i] == nums2[j]) {
					dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : 1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
	}
}
