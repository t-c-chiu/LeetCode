package medium;

public class MaxConsecutiveOnesIII {
	
	public static void main(String[] args) {
		MaxConsecutiveOnesIII test = new MaxConsecutiveOnesIII();
		System.out.println(test.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
		System.out.println(test.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
	}
	
	public int longestOnes(int[] nums, int k) {
		int n = nums.length;
		int left = 0;
		int right = 0;
		int res = 0;
		while (right < n) {
			while (right < n && k > 0) {
				if (nums[right] == 0) {
					k--;
				}
				right++;
			}
			while (right < n && nums[right] == 1) {
				right++;
			}
			res = Math.max(res, right - left);
			while (left < n && nums[left] == 1) {
				left++;
			}
			left++;
			k++;
		}
		return res;
	}
}
