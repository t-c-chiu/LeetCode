package medium;

public class NextPermutation {
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 1, 3, 3};
		nextPermutation(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	/**
	 * 1 3 5 2 4
	 * 1 3 5 4 2
	 * 1 4 2 3 5
	 * 1 4 2 5 3
	 * 1 4 3 2 5
	 */
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}
	
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	private static void reverse(int[] nums, int i) {
		int left = i;
		int right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}
}
