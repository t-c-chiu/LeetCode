package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfExcellentPairs {
	
	public static void main(String[] args) {
		long res = countExcellentPairs(new int[]{1, 2, 3, 1}, 3);
		System.out.println(res);
	}
	
	/**
	 * 101 101
	 * &   |
	 * 011 011
	 * 001 111
	 */
	public static long countExcellentPairs(int[] nums, int k) {
		long res = 0;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int num : nums) {
			int bits = Integer.bitCount(num);
			map.putIfAbsent(bits, new HashSet<>());
			map.get(bits).add(num);
		}
		Set<Integer> seen = new HashSet<>();
		for (int num : nums) {
			if (seen.contains(num)) {
				continue;
			}
			int bits = Integer.bitCount(num);
			for (Integer c : map.keySet()) {
				if (bits + c >= k) {
					res += map.get(c).size();
				}
			}
			seen.add(num);
		}
		return res;
	}
	
}
