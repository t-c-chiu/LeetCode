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
			
			int left = helper(preSum, preSum[i - 1], i, true);
			int right = helper(preSum, preSum[i - 1], i, false);
			if (left == -1 || right == -1) {
				continue;
			}
			res = (res + (right - left + 1) % mod) % mod;
		}
		return res;
	}
	
	private static int helper(int[] preSum, int leftSum, int i, boolean searchLeft) {
		int res = -1, n = preSum.length, low = i, high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2, midSum = preSum[mid] - leftSum, rightSum = preSum[n - 1] - preSum[mid];
			if (leftSum <= midSum && midSum <= rightSum) {
				res = mid;
				if (searchLeft) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (leftSum > midSum) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return res;
	}
}
