package easy;

public class MaximumAlternatingSubarraySum {
	
	public static void main(String[] args) {
		long res = maximumAlternatingSubarraySum(new int[]{3, -1, 1, 2});
		System.out.println(res);
	}
	
	public static long maximumAlternatingSubarraySum(int[] nums) {
		long res = Integer.MIN_VALUE, lastPlus = Integer.MIN_VALUE, lastMinus = Integer.MIN_VALUE;
		for (int num : nums) {
			long curPlus = Math.max(lastMinus + num, num);
			lastMinus = lastPlus - num;
			lastPlus = curPlus;
			res = Math.max(res, Math.max(lastMinus, lastPlus));
		}
		return res;
	}
}
