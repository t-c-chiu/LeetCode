package easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
	
	public static void main(String[] args) {
		int res = findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2});
		System.out.println(res);
	}
	
	public static int findShortestSubArray(int[] nums) {
		int res = 0, max = 0;
		Map<Integer, Integer> firstPos = new HashMap<>();
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			firstPos.putIfAbsent(num, i);
			count.put(num, count.getOrDefault(num, 0) + 1);
			if (count.get(num) > max) {
				max = count.get(num);
				res = i - firstPos.get(num) + 1;
			} else if (count.get(num) == max) {
				res = Math.min(res, i - firstPos.get(num) + 1);
			}
		}
		return res;
	}
	
}
