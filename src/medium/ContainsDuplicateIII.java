package medium;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		boolean res = containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
		System.out.println(res);
	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long num = nums[i];
			Long floor = set.floor(num);
			Long ceiling = set.ceiling(num);
			if (floor != null && num - floor <= t || ceiling != null && ceiling - num <= t) {
				return true;
			}
			set.add(num);
			if (i - k >= 0) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}
}
