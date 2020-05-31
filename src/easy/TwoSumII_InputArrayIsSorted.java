package easy;

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted {
	
	public static void main(String[] args) {
		TwoSumII_InputArrayIsSorted test = new TwoSumII_InputArrayIsSorted();
		System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
	}
	
	public int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target)
				return new int[]{left + 1, right + 1};
			if (sum < target)
				left++;
			if (sum > target)
				right--;
		}
		return new int[]{};
	}
}
