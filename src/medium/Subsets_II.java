package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
	
	public static void main(String[] args) {
		Subsets_II test = new Subsets_II();
		List<List<Integer>> res = test.subsetsWithDup(new int[]{1, 2, 2});
		System.out.println(res);
	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		subsetsWithDup(nums, res, new ArrayList<>(), 0);
		return res;
	}
	
	private void subsetsWithDup(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
		res.add(new ArrayList<>(temp));
		
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			subsetsWithDup(nums, res, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
