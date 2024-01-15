package medium;

public class WaysToSplitArrayIntoGoodSubarrays {
	
	public static void main(String[] args) {
		int res = numberOfGoodSubarraySplits(new int[]{0, 1, 0, 0, 1, 0, 0, 1});
		System.out.println(res);
	}
	
	/**
	 * 01,001
	 * 010,01
	 * 0100,1
	 * <p>
	 * 01,001,001
	 * 01,0010,01
	 * 01,00100,1
	 * 010,01,001
	 * 010,010,01
	 * 010,0100,1
	 * 0100,1,001
	 * 0100,10,01
	 * 0100,100,1
	 */
	public static int numberOfGoodSubarraySplits(int[] nums) {
		long res = 0;
		int mod = (int) (1e9 + 7), lastOne = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (lastOne == -1) {
					res = 1;
				} else {
					res = (res * (i - lastOne)) % mod;
				}
				lastOne = i;
			}
		}
		return lastOne == -1 ? 0 : (int) res;
	}
}
