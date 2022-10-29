package medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {
	
	public static void main(String[] args) {
		long res = countBadPairs(new int[]{4, 1, 3, 3});
		System.out.println(res);
	}
	
	// i < j and j - i != nums[j] - nums[i]
	// i < j and j - nums[j] == i - nums[i], good pairs
	public static long countBadPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		long goodPairs = 0;
		for (int i = 0; i < nums.length; i++) {
			Integer count = map.getOrDefault(i - nums[i], 0);
			goodPairs += count;
			map.put(i - nums[i], count + 1);
		}
		int n = nums.length;
		long allPairs = (long) (1 + n - 1) * (n - 1) / 2;
		return allPairs - goodPairs;
	}
}
