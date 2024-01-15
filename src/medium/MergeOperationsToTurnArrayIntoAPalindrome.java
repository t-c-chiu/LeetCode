package medium;

public class MergeOperationsToTurnArrayIntoAPalindrome {
	
	public static void main(String[] args) {
		int res = minimumOperations(new int[]{4, 3, 2, 1, 2, 3, 1});
		System.out.println(res);
	}
	
	public static int minimumOperations(int[] nums) {
		int res = 0, l = 0, r = nums.length - 1;
		while (l < r) {
			int lSum = nums[l], rSum = nums[r];
			while (l < r && lSum != rSum) {
				if (lSum < rSum) {
					lSum += nums[++l];
				} else {
					rSum += nums[--r];
				}
				res++;
			}
			l++;
			r--;
		}
		return res;
	}
	
}
