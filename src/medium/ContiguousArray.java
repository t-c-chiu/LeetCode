package medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	
	public static void main(String[] args) {
		int res = findMaxLength(new int[]{0, 0, 1, 1, 0, 1, 0, 1, 1});
		System.out.println(res);
	}
	
	// 0 -1 -2 -1 0 -1 0 -1 0 1
	public static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int count = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? 1 : -1;
			if (map.containsKey(count)) {
				res = Math.max(res, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return res;
	}
}
