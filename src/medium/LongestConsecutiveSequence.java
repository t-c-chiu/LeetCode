package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		int res = longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
		System.out.println(res);
	}
	
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int num : nums) {
			set.add(num);
		}
		for (int num : nums) {
			if (set.contains(num)) {
				int i = num, len = 0;
				while (set.contains(i)) {
					len++;
					set.remove(i++);
				}
				i = num - 1;
				while (set.contains(i)) {
					len++;
					set.remove(i--);
				}
				res = Math.max(res, len);
			}
		}
		return res;
	}
}
