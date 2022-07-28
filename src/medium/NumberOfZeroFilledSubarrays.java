package medium;

public class NumberOfZeroFilledSubarrays {
	
	public static void main(String[] args) {
		long res = zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0});
		System.out.println(res);
	}
	
	/**
	 * 0 - 1 - 1
	 * 00 - 3 - 1 + 2
	 * 000 - 6 - 1 + 2 + 3
	 * 0000 - 10 - 1 + 2 + 3 + 4
	 */
	public static long zeroFilledSubarray(int[] nums) {
		long res = 0;
		for (int r = 0, l = 0; r < nums.length; r++) {
			if (nums[r] == 0 && (r == nums.length - 1 || nums[r + 1] != 0)) {
				while (nums[l] != 0) {
					l++;
				}
				int count = r - l + 1;
				res += (long) (1 + count) * count / 2;
				l = r = r + 1;
			}
		}
		return res;
	}
}
