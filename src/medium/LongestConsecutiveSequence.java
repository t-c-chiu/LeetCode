package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		int res = longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
		System.out.println(res);
	}
	
	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		
		int res = 1;
		for (int num : nums) {
			if (set.remove(num)) {
				int i = num;
				int sum = 1;
				while (set.remove(--i)) {
					sum++;
				}
				
				i = num;
				while (set.remove(++i)) {
					sum++;
				}
				
				res = Math.max(res, sum);
			}
		}
		return res;
	}
}
