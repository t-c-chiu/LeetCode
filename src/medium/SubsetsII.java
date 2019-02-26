package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static void main(String[] args) {
		SubsetsII subsetsII = new SubsetsII();
		subsetsII.subsetsWithDup(new int[]{1, 2, 2});
	}

	//	Input: [1,2,2]
	//	Output:
	//	[
	//		[2],
	//		[1],
	//		[1,2,2],
	//		[2,2],
	//		[1,2],
	//		[]
	//	]
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null) return results;

		if (nums.length == 0) {
			results.add(new ArrayList<Integer>());
			return results;
		}
		Arrays.sort(nums);

		List<Integer> subset = new ArrayList<Integer>();
		helper(nums, 0, subset, results);

		return results;
	}

	public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
		results.add(new ArrayList<>(subset));
		for (int i = startIndex; i < nums.length; i++) {
			if (i != startIndex && nums[i] == nums[i - 1]) {
				continue;
			}
			subset.add(nums[i]);
			helper(nums, i + 1, subset, results);
			subset.remove(subset.size() - 1);
		}
	}
}
