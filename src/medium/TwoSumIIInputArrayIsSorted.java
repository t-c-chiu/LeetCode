package medium;

public class TwoSumIIInputArrayIsSorted {
	
	public static void main(String[] args) {
		int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
		System.out.println(res[0] + ", " + res[1]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				return new int[]{left + 1, right + 1};
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return null;
	}
}
