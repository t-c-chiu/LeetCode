package easy;

public class LongestContinuousIncreasingSubsequence {
	
	public static void main(String[] args) {
		LongestContinuousIncreasingSubsequence subsequence = new LongestContinuousIncreasingSubsequence();
		System.out.println(subsequence.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
		System.out.println(subsequence.findLengthOfLCIS(new int[]{2, 2, 2,}));
	}
	
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		int max = 1, count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				max = Math.max(max, ++count);
			else
				count = 1;
		}
		return max;
	}
}
