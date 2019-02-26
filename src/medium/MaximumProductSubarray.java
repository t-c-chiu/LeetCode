package medium;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
		System.out.println(maximumProductSubarray.maxProduct(new int[]{2, 3, -2, 4}));
		System.out.println(maximumProductSubarray.maxProduct(new int[]{7, -5, -3, 6, -1, 2}));
		System.out.println(maximumProductSubarray.maxProduct(new int[]{0, 4, 7, 0, -1, -2}));
	}

	//	Input: [2,3,-2,4]
	//	Output: 6
	//	Explanation: [2,3] has the largest product 6.
	public int maxProduct(int[] nums) {
		int res, min, max;
		res = min = max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int tempMax = max;
			max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
			min = Math.min(Math.min(min * nums[i], tempMax * nums[i]), nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
}
