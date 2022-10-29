package medium;

public class MaximumLengthOfSubarrayWithPositiveProduct {
	
	public static void main(String[] args) {
		int res = getMaxLen(new int[]{1, -2, -3, 4, 5, 0, -4, 2, -3, 1, 1, 4, 5});
		System.out.println(res);
	}
	
	public static int getMaxLen(int[] nums) {
		int n = nums.length, res = 0, lastZero = -1, firstNeg = -1, negCount = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				lastZero = i;
				negCount = 0;
				firstNeg = -1;
				continue;
			}
			if (nums[i] < 0) {
				negCount++;
				if (firstNeg == -1) {
					firstNeg = i;
				}
			}
			if (negCount % 2 == 1) {
				res = Math.max(res, i - firstNeg);
			} else {
				res = Math.max(res, i - lastZero);
			}
		}
		return res;
	}
	
}
