package easy;

public class Range_Sum_Query {
	class NumArray {
		private int[] sum;
		
		public NumArray(int[] nums) {
			for (int i = 1; i < nums.length; i++)
				nums[i] += nums[i - 1];
			sum = nums;
		}
		
		public int sumRange(int i, int j) {
			return i == 0 ? sum[j] : sum[j] - sum[i - 1];
		}
	}
}
