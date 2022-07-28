package medium;

public class MaximumLengthOfSubarrayWithPositiveProduct {
	
	public static void main(String[] args) {
		int res = getMaxLen(new int[]{1, -2, -3, 4, 5, 0, -4, 2, -3, 1, 1, 4, 5});
		System.out.println(res);
	}
	
	public static int getMaxLen(int[] nums) {
		int lastZero = -1, firstNegative = -1, negativeCount = 0, res = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == 0) {
				lastZero = i;
				negativeCount = 0;
				firstNegative = -1;
			} else if (num < 0) {
				if (firstNegative == -1) {
					firstNegative = i;
				}
				negativeCount++;
			}
			res = Math.max(res, negativeCount % 2 == 0 ? i - lastZero : i - firstNegative);
		}
		return res;
	}

//	public static int getMaxLen(int[] nums) {
//		int res = 0, positive = 0, negative = 0;
//		for (int num : nums) {
//			if (num == 0) {
//				positive = 0;
//				negative = 0;
//			} else if (num > 0) {
//				positive++;
//				negative = negative == 0 ? 0 : negative + 1;
//			} else {
//				int temp = positive;
//				positive = negative == 0 ? 0 : negative + 1;
//				negative = temp + 1;
//			}
//			res = Math.max(res, positive);
//		}
//		return res;
//	}

}
