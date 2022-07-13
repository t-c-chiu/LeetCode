package medium;

public class MaximumLengthOfSubarrayWithPositiveProduct {
	
	public static void main(String[] args) {
		int res = getMaxLen(new int[]{1, -2, -3, 4});
		System.out.println(res);
	}
	
	public static int getMaxLen(int[] nums) {
		int res = 0, zeroIndex = -1, firstNegIndex = -1, negCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroIndex = i;
				firstNegIndex = -1;
				negCount = 0;
				continue;
			}
			if (nums[i] < 0) {
				if (firstNegIndex == -1) {
					firstNegIndex = i;
				}
				negCount++;
			}
			res = Math.max(res, i - (negCount % 2 == 0 ? zeroIndex : firstNegIndex));
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
