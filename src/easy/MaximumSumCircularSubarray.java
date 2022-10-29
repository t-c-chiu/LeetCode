package easy;

public class MaximumSumCircularSubarray {
	
	public static void main(String[] args) {
		int res = maxSubarraySumCircular(new int[]{-3, -2, -3});
		System.out.println(res);
	}
	
	public static int maxSubarraySumCircular(int[] nums) {
		int curMax = -30000, curMin = 30000, maxSub = curMax, minSub = curMin, sum = 0;
		for (int num : nums) {
			curMax = Math.max(curMax + num, num);
			maxSub = Math.max(maxSub, curMax);
			curMin = Math.min(curMin + num, num);
			minSub = Math.min(minSub, curMin);
			sum += num;
		}
		return maxSub > 0 ? Math.max(maxSub, sum - minSub) : maxSub;
	}
}
