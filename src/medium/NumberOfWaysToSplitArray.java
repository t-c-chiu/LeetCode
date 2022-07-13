package medium;

public class NumberOfWaysToSplitArray {
	
	public static void main(String[] args) {
		int res = waysToSplitArray(new int[]{10, 4, -8, 7});
		System.out.println(res);
	}
	
	public static int waysToSplitArray(int[] nums) {
		long rightSum = 0, leftSum = 0;
		int res = 0;
		for (int num : nums) {
			rightSum += num;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			leftSum += nums[i];
			rightSum -= nums[i];
			if (leftSum >= rightSum) {
				res++;
			}
		}
		return res;
	}
}
