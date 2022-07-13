package medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray {
	
	public static void main(String[] args) {
		int res = findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
		System.out.println(res);
	}
	
	/**
	 * 3 -     11
	 * 10 -  1010
	 * 5 -    101
	 * 25 - 11001
	 * 2 -     10
	 * 8 -   1000
	 * max- 11100
	 */
	public static int findMaximumXOR(int[] nums) {
		int res = 0, mask = 0;
		for (int i = 31; i >= 0; i--) {
			Set<Integer> set = new HashSet<>();
			mask = mask | (1 << i);
			for (int num : nums) {
				set.add(num & mask);
			}
			int target = res | (1 << i);
			for (Integer j : set) {
				if (set.contains(target ^ j)) {
					res = target;
					break;
				}
			}
		}
		return res;
	}
}
