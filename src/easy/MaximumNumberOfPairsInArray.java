package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairsInArray {
	
	public static void main(String[] args) {
		int[] res = numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] numberOfPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int[] res = new int[2];
		for (Integer count : map.values()) {
			res[0] += count / 2;
			res[1] += count % 2;
		}
		return res;
	}
}
