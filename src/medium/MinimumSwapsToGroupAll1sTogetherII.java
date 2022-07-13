package medium;

public class MinimumSwapsToGroupAll1sTogetherII {
	
	public static void main(String[] args) {
		int res = minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0});
		System.out.println(res);
	}
	
	public static int minSwaps(int[] nums) {
		int ones = 0, swap = 0, n = nums.length;
		for (int num : nums) {
			if (num == 1) {
				ones++;
			}
		}
		for (int i = 0; i < ones; i++) {
			if (nums[i] == 0) {
				swap++;
			}
		}
		int res = swap;
		for (int i = ones; i < n + ones - 1; i++) {
			if (nums[(i - ones) % n] == 0) {
				swap--;
			}
			if (nums[i % n] == 0) {
				swap++;
			}
			res = Math.min(res, swap);
		}
		return res;
	}
}
