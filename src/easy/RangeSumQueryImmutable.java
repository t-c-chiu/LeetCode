package easy;

public class RangeSumQueryImmutable {
	
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
		numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
		numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
		numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
	}
	
	static class NumArray {
		
		int[] sums;
		
		public NumArray(int[] nums) {
			int n = nums.length;
			sums = new int[n + 1];
			sums[0] = 0;
			for (int i = 1; i <= n; i++) {
				sums[i] = sums[i - 1] + nums[i - 1];
			}
		}
		
		public int sumRange(int left, int right) {
			return sums[right + 1] - sums[left];
		}
	}
}
