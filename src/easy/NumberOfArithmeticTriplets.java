package easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfArithmeticTriplets {
	
	public static void main(String[] args) {
		int res = arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3);
		System.out.println(res);
	}
	
	public static int arithmeticTriplets(int[] nums, int diff) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			res += map.getOrDefault(num - diff, 0) * map.getOrDefault(num - diff * 2, 0);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return res;
	}
}
