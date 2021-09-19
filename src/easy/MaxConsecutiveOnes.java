package easy;

public class MaxConsecutiveOnes {
	
	public static void main(String[] args) {
	
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int res = 0;
		int count = 0;
		for (int num : nums) {
			count = num == 1 ? count + 1 : 0;
			res = Math.max(res, count);
		}
		return res;
	}
}
