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
		return result;
	}
}
