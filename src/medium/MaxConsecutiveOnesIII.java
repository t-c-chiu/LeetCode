package medium;

public class MaxConsecutiveOnesIII {
	
	public static void main(String[] args) {
		MaxConsecutiveOnesIII test = new MaxConsecutiveOnesIII();
		System.out.println(test.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
		System.out.println(test.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
	}
	
	public int longestOnes(int[] nums, int k) {
		int left = 0, right = 0;
		while (right < nums.length) {
			if (nums[right] == 0) {
				k--;
			}
			if (k < 0) {
				if (nums[left] == 0) {
					k++;
				}
				left++;
			}
			right++;
		}
		return right - left;
	}
//	public int longestOnes(int[] nums, int k) {
//		int left = 0;
//		int right = 0;
//		int res = 0;
//		int zero = 0;
//		while (right < nums.length) {
//			if (nums[right] == 0) {
//				zero++;
//			}
//			while (zero > k) {
//				if (nums[left] == 0) {
//					zero--;
//				}
//				left++;
//			}
//			res = Math.max(res, right - left + 1);
//			right++;
//		}
//		return res;
//	}
}
