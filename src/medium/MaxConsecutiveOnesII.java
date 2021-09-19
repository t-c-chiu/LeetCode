package medium;

public class MaxConsecutiveOnesII {
	
	public static void main(String[] args) {
		int res = findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 0, 0, 1});
		System.out.println(res);
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int res = 0, left = 0, right = 0, zero = 0, k = 1;
		while (right < nums.length) {
			if (nums[right] == 0) {
				zero++;
			}
			while (zero > k) {
				if (nums[left] == 0) {
					zero--;
				}
				left++;
			}
			res = Math.max(res, right - left + 1);
			right++;
		}
		return res;
	}
}
