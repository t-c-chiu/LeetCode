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
		int n = nums.length, zero = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				zero++;
			} else {
				nums[i - zero] = nums[i];
			}
		}
		for (int i = n - zero; i < n; i++) {
			nums[i] = 0;
		}
	}
}
