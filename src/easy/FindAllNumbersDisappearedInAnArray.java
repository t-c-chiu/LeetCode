package easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
	public static void main(String[] args) {
		FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
		System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(new int[]{4, 3, 2, 7, 2, 2, 3, 1}));
		System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(new int[]{2, 2}));
		System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(new int[]{}));
	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int value = Math.abs(nums[i]) - 1;
			if (nums[value] > 0)
				nums[value] = -nums[value];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				result.add(i + 1);
		}
		return result;
	}
}
