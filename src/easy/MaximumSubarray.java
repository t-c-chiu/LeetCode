package easy;

public class MaximumSubarray {
	public static void main(String[] args) {
		System.out.println(new MaximumSubarray().maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
	
	public int maxSubArray(int[] nums) {
		int sum = 0, max = sum;
		for (int i : nums) {
			if ((sum += i) < 0)
				sum = 0;
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public int maxSubArray2(int[] nums) {
		int sum = 0, max = sum;
		for (int i : nums) {
			sum = sum >= 0 ? sum + i : i;
			max = Math.max(max, sum);
		}
		return max;
	}
}
