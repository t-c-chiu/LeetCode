package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args) {
		for (List<Integer> list : new Subsets().subsets(new int[]{1, 2, 3, 4})) {
			System.out.println(list);
		}
	}
	
	// 1, 2, 3, 4
	// 1 12 123 1234 124 13 134 14 2 23 234 24 3 34 4
	//
	private List<List<Integer>> result = new ArrayList<>();
	
	public List<List<Integer>> subsets(int[] nums) {
		int length = nums.length;
		result.add(Arrays.asList(nums[length - 1]));
		helper(length - 2, nums);
		result.add(Arrays.asList());
		return result;
	}
	
	private void helper(int i, int[] nums) {
		if (i < 0)
			return;
		
		int num = nums[i];
		for (List<Integer> list : new ArrayList<>(result)) {
			List<Integer> temp = new ArrayList<>();
			temp.add(num);
			temp.addAll(list);
			result.add(temp);
		}
		result.add(Arrays.asList(num));
		helper(i - 1, nums);
	}
}
