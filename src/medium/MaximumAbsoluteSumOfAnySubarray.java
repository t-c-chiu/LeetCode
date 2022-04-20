package medium;

public class MaximumAbsoluteSumOfAnySubarray {
	
	public static void main(String[] args) {
		int res = maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2});
		System.out.println(res);
	}
	
	public static int maxAbsoluteSum(int[] nums) {
		int res = 0, min = 0, max = 0;
		for (int num : nums) {
			min = Math.min(0, min + num);
			max = Math.max(0, max + num);
			res = Math.max(res, Math.max(max, -min));
		}
		return res;
	}
}
