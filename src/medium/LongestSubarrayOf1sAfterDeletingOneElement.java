package medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {
	
	public static void main(String[] args) {
		int res = longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
		System.out.println(res);
	}
	
	public static int longestSubarray(int[] nums) {
		int res = 0, k = 1;
		for (int l = 0, r = 0; r < nums.length; r++) {
			if (nums[r] == 0) {
				k--;
			}
			while (k < 0) {
				if (nums[l++] == 0) {
					k++;
				}
			}
			res = Math.max(res, r - l);
		}
		return res;
	}
	
}
