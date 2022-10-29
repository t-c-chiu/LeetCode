package hard;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
	
	public static void main(String[] args) {
		int res = subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
		System.out.println(res);
	}
	
	public static int subarraysWithKDistinct(int[] nums, int k) {
		return atMost(nums, k) - atMost(nums, k - 1);
	}
	
	private static int atMost(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0, j = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.getOrDefault(num, 0) == 0) {
				k--;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
			while (k < 0) {
				num = nums[j++];
				map.put(num, map.get(num) - 1);
				if (map.get(num) == 0) {
					k++;
				}
			}
			res += i - j + 1;
		}
		return res;
	}
}
