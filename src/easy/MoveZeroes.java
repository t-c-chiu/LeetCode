package easy;

public class MoveZeroes {
	
	public static void main(String[] args) {
		int[] array = new int[]{0, 1, 0, 3, 12};
		moveZeroes(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
	
	public static void moveZeroes(int[] nums) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				swap(nums, i++, j);
			}
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
