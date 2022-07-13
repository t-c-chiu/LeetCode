package easy;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
	
	public static void main(String[] args) {
		int res = maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6});
		System.out.println(res);
	}
	
	public static int maximumUniqueSubarray(int[] nums) {
		int res = 0, cur = 0, left = 0;
		Set<Integer> set = new HashSet<>();
		for (int right = 0; right < nums.length; right++) {
			while (set.contains(nums[right])) {
				cur -= nums[left];
				set.remove(nums[left]);
				left++;
			}
			cur += nums[right];
			set.add(nums[right]);
			res = Math.max(res, cur);
		}
		return res;
	}
}
