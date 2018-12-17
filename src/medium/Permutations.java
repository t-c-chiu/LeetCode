package medium;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	
	public static void main(String[] args) {
		for (List<Integer> list : new Permutations().permute(new int[]{1, 2, 3})) {
			System.out.println(list);
		}
	}
	
	private List<List<Integer>> result = new LinkedList<>();
	
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> temp = new LinkedList<>();
		helper(nums, temp);
		return result;
	}
	
	private void helper(int[] nums, List<Integer> temp) {
		if (temp.size() == nums.length) {
			List<Integer> list = new LinkedList<>(temp);
			result.add(list);
		} else {
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				if (temp.contains(num)) {
					continue;
				}
				temp.add(num);
				helper(nums, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
}
