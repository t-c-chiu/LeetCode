package medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {
	
	public static void main(String[] args) {
		int res = longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
		System.out.println(res);
	}
	
	public static int longestSubarray(int[] nums) {
		int res = 0;
		int i = 0;
		int k = 1;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == 0) {
				k--;
			}
			while (k < 0) {
				if (nums[i] == 0) {
					k++;
				}
				i++;
			}
			res = Math.max(res, j - i);
		}
		return res;
	}
	
}
