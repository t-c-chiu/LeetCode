package medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
	
	public static void main(String[] args) {
		int res = maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5});
		System.out.println(res);
	}
	
	public static int maximumUniqueSubarray(int[] nums) {
		int res = 0, sum = 0, l = 0;
		Set<Integer> set = new HashSet<>();
		for (int r = 0; r < nums.length; r++) {
			while (set.contains(nums[r])) {
				set.remove(nums[l]);
				sum -= nums[l];
				l++;
			}
			sum += nums[r];
			set.add(nums[r]);
			res = Math.max(res, sum);
		}
		return res;
	}
}
