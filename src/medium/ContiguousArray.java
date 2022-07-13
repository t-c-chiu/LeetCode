package medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	
	public static void main(String[] args) {
		int res = findMaxLength(new int[]{0, 0, 1, 1, 0, 1, 0, 1, 1});
		System.out.println(res);
	}
	
	public static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0, res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] == 0 ? -1 : 1;
			map.putIfAbsent(sum, i);
			res = Math.max(res, i - map.get(sum));
		}
		return res;
	}
}
