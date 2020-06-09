package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
	
	public static void main(String[] args) {
		Three_Sum test = new Three_Sum();
		List<List<Integer>> res = test.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		System.out.println(res);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1, right = length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}
