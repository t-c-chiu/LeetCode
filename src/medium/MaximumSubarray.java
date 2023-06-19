package medium;

public class MaximumSubarray {
	public static void main(String[] args) {
		int res = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
		System.out.println(res);
	}
	
	public static int maxSubArray(int[] nums) {
		int sum = 0, max = Integer.MIN_VALUE;
		for (int num : nums) {
			sum = Math.max(sum + num, num);
			max = Math.max(max, sum);
		}
		return max;
	}
	
}
