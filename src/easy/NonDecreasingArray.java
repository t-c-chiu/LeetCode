package easy;

public class NonDecreasingArray {
	public static void main(String[] args) {
		boolean res = checkPossibility(new int[]{4, 2, 3});
		System.out.println(res);
	}
	
	public static boolean checkPossibility(int[] nums) {
		boolean modified = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				if (modified) {
					return false;
				}
				modified = true;
				if (i == 1 || nums[i] >= nums[i - 2]) {
					nums[i - 1] = nums[i];
				} else {
					nums[i] = nums[i - 1];
				}
			}
		}
		return true;
	}
}
