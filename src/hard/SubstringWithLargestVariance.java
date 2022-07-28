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
		int n = nums.length;
		int[] maxFromLeft = new int[n];
		maxFromLeft[0] = nums[0];
		for (int i = 1; i < n; i++) {
			maxFromLeft[i] = Math.max(maxFromLeft[i - 1] + nums[i], nums[i]);
		}
		int res = 0, maxFromRight = 0;
		for (int i = n - 1; i >= 0; i--) {
			maxFromRight = Math.max(maxFromRight + nums[i], nums[i]);
			if (nums[i] == -1) {
				res = Math.max(res, maxFromLeft[i] + maxFromRight + 1);
			}
		}
		return res;
	}
}
