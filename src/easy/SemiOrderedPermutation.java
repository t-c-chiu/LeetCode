package easy;

public class SemiOrderedPermutation {
	
	public static void main(String[] args) {
	
	}
	
	public static int semiOrderedPermutation(int[] nums) {
		int n = nums.length, left = 0, right = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 1) {
				left = i;
			}
			if (nums[i] == n) {
				right = i;
			}
		}
		int res = left + n - right - 1;
		if (left > right) {
			res--;
		}
		return res;
	}
	
}
