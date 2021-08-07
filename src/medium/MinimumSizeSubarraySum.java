package medium;

public class MinimumSizeSubarraySum {
	
	public static void main(String[] args) {
		int res = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
		System.out.println(res);
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
		int res = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= target) {
				res = Math.min(res, right - left + 1);
				sum -= nums[left++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
