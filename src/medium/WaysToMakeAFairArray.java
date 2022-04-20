package medium;

public class WaysToMakeAFairArray {
	
	public static void main(String[] args) {
		int res = waysToMakeFair(new int[]{2, 1, 6, 4});
		System.out.println(res);
	}
	
	public static int waysToMakeFair(int[] nums) {
		int res = 0;
		int rightEven = 0;
		int rightOdd = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				rightEven += nums[i];
			} else {
				rightOdd += nums[i];
			}
		}
		int leftEven = 0;
		int leftOdd = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				rightEven -= nums[i];
			} else {
				rightOdd -= nums[i];
			}
			if (leftEven + rightOdd == leftOdd + rightEven) {
				res++;
			}
			if (i % 2 == 0) {
				leftEven += nums[i];
			} else {
				leftOdd += nums[i];
			}
		}
		return res;
	}
}
