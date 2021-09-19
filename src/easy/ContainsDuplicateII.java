package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {
	
	public static void main(String[] args) {
		boolean res = containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
		System.out.println(res);
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i - k > 0) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

//	public static boolean containsNearbyDuplicate(int[] nums, int k) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			int num = nums[i];
//			if (map.containsKey(num) && Math.abs(map.get(num) - i) <= k) {
//				return true;
//			}
//			map.put(num, i);
//		}
//		return false;
//	}
}
