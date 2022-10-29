package medium;

public class NumberOfLongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int res = findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
		System.out.println(res);
	}
	
	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length, res = 0;
		int[] len = new int[n];
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			len[i] = count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (len[j] + 1 > len[i]) {
						len[i] = len[j] + 1;
						count[i] = count[j];
					} else if (len[j] + 1 == len[i]) {
						count[i] += count[j];
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (len[i] > max) {
				max = len[i];
				res = count[i];
			} else if (len[i] == max) {
				res += count[i];
			}
		}
		return res;
	}
}
