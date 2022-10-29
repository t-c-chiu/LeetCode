package medium;

public class MinimumAdjacentSwapsToMakeAValidArray {
	
	public static void main(String[] args) {
		int res = minimumSwaps(new int[]{9});
		System.out.println(res);
	}
	
	public static int minimumSwaps(int[] nums) {
		int min = 0, max = 0, n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] < nums[min]) {
				min = i;
			}
			if (nums[i] >= nums[max]) {
				max = i;
			}
		}
		int res = min + n - max - 1;
		if (min > max) {
			res--;
		}
		return res;
	}
}
