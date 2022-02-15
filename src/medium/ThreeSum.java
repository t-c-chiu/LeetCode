package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args) {
		List<List<Integer>> res = threeSum(new int[]{-2, 0, 0, 2, 2});
		System.out.println(res);
	}
	
	/**
	 * -4 -1 -1 0 1 2
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
					while (l < r && nums[l - 1] == nums[l]) {
						l++;
					}
					while (l < r && nums[r + 1] == nums[r]) {
						r--;
					}
				} else if (sum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		return res;
	}
}
