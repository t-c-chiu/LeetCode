package medium;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		boolean res = containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
		System.out.println(res);
	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int r = 0, l = 0; r < nums.length; r++) {
			int num = nums[r];
			if (l < r - indexDiff) {
				set.remove(nums[l++]);
			}
			if (!set.subSet(num - valueDiff, true, num + valueDiff, true).isEmpty()) {
				return true;
			}
			set.add(num);
		}
		return false;
	}
}
