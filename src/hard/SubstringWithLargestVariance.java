package hard;

import java.util.HashSet;
import java.util.Set;

public class SubstringWithLargestVariance {
	
	public static void main(String[] args) {
		int res = largestVariance("aababbb");
		System.out.println(res);
	}
	
	public static int largestVariance(String s) {
		int n = s.length(), res = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(s.charAt(i));
		}
		for (char i = 'a'; i <= 'z'; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				if (i == j || !set.contains(i) || !set.contains(j)) {
					continue;
				}
				int[] nums = new int[n];
				for (int k = 0; k < n; k++) {
					if (s.charAt(k) == i) {
						nums[k] = 1;
					} else if (s.charAt(k) == j) {
						nums[k] = -1;
					}
				}
				res = Math.max(res, helper(nums));
			}
		}
		return res;
	}
	
	private static int helper(int[] nums) {
		int res = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, max + nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
}
