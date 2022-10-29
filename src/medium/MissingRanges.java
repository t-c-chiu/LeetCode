package medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	
	public static void main(String[] args) {
		List<String> res = findMissingRanges(new int[]{0, 1, 3, 50, 75}, -2, 99);
		System.out.println(res);
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		int n = nums.length;
		if (n == 0) {
			helper(res, lower, upper);
			return res;
		}
		helper(res, lower, nums[0] - 1);
		for (int i = 1; i < n; i++) {
			helper(res, nums[i - 1] + 1, nums[i] - 1);
		}
		helper(res, nums[n - 1] + 1, upper);
		return res;
	}
	
	private static void helper(List<String> res, int from, int to) {
		if (from == to) {
			res.add(String.valueOf(from));
		} else if (from < to) {
			res.add(from + "->" + to);
		}
	}
}
