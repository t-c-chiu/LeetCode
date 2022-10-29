package medium;

public class WaysToSplitArrayIntoThreeSubarrays {
	
	public static void main(String[] args) {
		int res = waysToSplit(new int[]{1, 2, 2, 2, 5, 0});
		System.out.println(res);
	}
	
	/**
	 * 1 3 5 7 12 12
	 */
	public static int waysToSplit(int[] nums) {
		int n = nums.length, res = 0, mod = (int) (1e9 + 7);
		int[] preSum = new int[n];
		preSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		for (int i = 1; i < n - 1; i++) {
			if (preSum[i - 1] > preSum[n - 1] / 3) {
				break;
			}
			int left = binarySearch(i, n - 2, preSum, true);
			int right = binarySearch(i, n - 2, preSum, false);
			if (left != -1 && right != -1) {
				res = (res + (right - left + 1) % mod) % mod;
			}
		}
		return res;
	}
	
	private static int binarySearch(int lo, int hi, int[] preSum, boolean searchLeft) {
		int res = -1, leftSum = preSum[lo - 1];
		while (lo <= hi) {
			int mid = (lo + hi) / 2, midSum = preSum[mid] - leftSum, rightSum = preSum[preSum.length - 1] - preSum[mid];
			if (leftSum <= midSum && midSum <= rightSum) {
				res = mid;
				if (searchLeft) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else if (leftSum > midSum) {
				lo = mid + 1;
			} else if (midSum > rightSum) {
				hi = mid - 1;
			}
		}
		return res;
	}
	
}
