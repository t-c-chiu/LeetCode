package easy;

import java.util.HashSet;
import java.util.Set;

public class FindSubarraysWithEqualSum {
	
	public static void main(String[] args) {
		boolean res = findSubarrays(new int[]{4, 2, 4});
		System.out.println(res);
	}
	
	public static boolean findSubarrays(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < nums.length; i++) {
			int sum = nums[i - 1] + nums[i];
			if (!set.add(sum)) {
				return true;
			}
		}
		return false;
	}
}
