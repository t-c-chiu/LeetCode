package medium;

public class MinimumAverageDifference {
	
	public static void main(String[] args) {
		int res = minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3});
		System.out.println(res);
	}
	
	public static int minimumAverageDifference(int[] nums) {
		int n = nums.length;
		long leftSum = 0;
		long rightSum = 0;
		for (int num : nums) {
			rightSum += num;
		}
		int res = 0;
		long diff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			leftSum += nums[i];
			rightSum -= nums[i];
			long newDiff = Math.abs(leftSum / (i + 1) - (n - i == 1 ? 0 : rightSum / (n - i - 1)));
			if (newDiff < diff) {
				diff = newDiff;
				res = i;
			}
		}
		return res;
	}
}
