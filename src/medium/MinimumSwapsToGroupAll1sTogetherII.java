package medium;

public class MinimumSwapsToGroupAll1sTogetherII {
	
	public static void main(String[] args) {
		int res = minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0});
		System.out.println(res);
	}
	
	public static int minSwaps(int[] nums) {
		int ones = 0;
		for (int num : nums) {
			if (num == 1) {
				ones++;
			}
		}
		int n = nums.length, res = Integer.MAX_VALUE, swap = 0;
		for (int r = 0, l = 0; r < n + ones; r++) {
			if (nums[r % n] == 0) {
				swap++;
			}
			if (r - l == ones) {
				if (nums[l] == 0) {
					swap--;
				}
				l++;
			}
			if (r - l + 1 == ones) {
				res = Math.min(res, swap);
			}
		}
		return res;
	}
}
