package medium;

public class MaximumSumOfTwoNonOverlappingSubarrays {
	
	public static void main(String[] args) {
		int res = maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2);
		System.out.println(res);
	}
	
	public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
		return Math.max(maxSum(nums, firstLen, secondLen), maxSum(nums, secondLen, firstLen));
	}
	
	private static int maxSum(int[] nums, int L, int R) {
		int sumL = 0, sumR = 0;
		for (int i = 0; i < L + R; i++) {
			if (i < L) {
				sumL += nums[i];
			} else {
				sumR += nums[i];
			}
		}
		int res = sumL + sumR;
		for (int i = L + R, maxL = sumL; i < nums.length; i++) {
			sumL += nums[i - R] - nums[i - R - L];
			sumR += nums[i] - nums[i - R];
			maxL = Math.max(maxL, sumL);
			res = Math.max(res, maxL + sumR);
		}
		return res;
	}
//	public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
//		int n = nums.length;
//		int[] preSum = new int[n + 1];
//		for (int i = 0; i < n; i++) {
//			preSum[i + 1] = preSum[i] + nums[i];
//		}
//		return Math.max(maxSum(preSum, firstLen, secondLen), maxSum(preSum, secondLen, firstLen));
//	}
//
//	private static int maxSum(int[] preSum, int L, int R) {
//		int maxL = 0, res = 0;
//		for (int i = L + R; i < preSum.length; i++) {
//			maxL = Math.max(maxL, preSum[i - R] - preSum[i - R - L]);
//			res = Math.max(res, maxL + preSum[i] - preSum[i - R]);
//		}
//		return res;
//	}
}
