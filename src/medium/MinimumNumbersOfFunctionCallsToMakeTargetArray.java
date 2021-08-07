package medium;

public class MinimumNumbersOfFunctionCallsToMakeTargetArray {
	
	public static void main(String[] args) {
		int res = minOperations(new int[]{2, 4, 8, 16});
		System.out.println(res);
	}
	
	public static int minOperations(int[] nums) {
		int res = 0;
		int maxDividedTimes = Integer.MIN_VALUE;
		for (int num : nums) {
			int dividedTimes = 0;
			while (num > 0) {
				if (num % 2 == 0) {
					dividedTimes++;
					num /= 2;
					if (dividedTimes > maxDividedTimes) {
						maxDividedTimes = dividedTimes;
						res++;
					}
				} else {
					num -= 1;
					res++;
				}
			}
		}
		return res;
	}

//	public static int minOperations(int[] nums) {
//		int n = nums.length;
//		int res = 0;
//		while (true) {
//			boolean allZero = true;
//			for (int i = 0; i < n; i++) {
//				if (nums[i] % 2 == 1) {
//					nums[i] -= 1;
//					res++;
//				}
//				if (nums[i] != 0) {
//					allZero = false;
//				}
//			}
//			if (allZero) {
//				break;
//			}
//			allZero = true;
//			for (int i = 0; i < n; i++) {
//				nums[i] /= 2;
//				if (nums[i] != 0) {
//					allZero = false;
//				}
//			}
//			res++;
//			if (allZero) {
//				break;
//			}
//		}
//		return res;
//	}
}
