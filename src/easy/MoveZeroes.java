package easy;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] array = new int[]{0, 1, 0, 3, 12};
		new MoveZeroes().moveZeroes(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public void moveZeroes(int[] nums) {
		int zeroCount = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] == 0) {
				zeroCount++;
				continue;
			}
			nums[i - zeroCount] = nums[i];
		}
		for (int j = length - zeroCount; j < length; j++) {
			nums[j] = 0;
		}
	}
}
