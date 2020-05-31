package medium;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_with_At_Least_K_Repeating_Characters {
	
	public static void main(String[] args) {
		Longest_Substring_with_At_Least_K_Repeating_Characters test = new Longest_Substring_with_At_Least_K_Repeating_Characters();
		int res = test.longestSubstring("aacbbccdabbc", 2);
		System.out.println(res);
	}
	
	public int longestSubstring(String s, int k) {
		return longestSubstring(s.toCharArray(), 0, s.length(), k);
	}
	
	private int longestSubstring(char[] chars, int start, int end, int k) {
		if (start >= end) {
			return 0;
		}
		
		Map<Character, Integer> freq = new HashMap<>();
		for (int i = start; i < end; i++) {
			freq.put(chars[i], freq.getOrDefault(chars[i], 0) + 1);
		}
		boolean flag = true;
		for (int i = start; i < end; i++) {
			if (freq.get(chars[i]) < k) {
				flag = false;
				break;
			}
		}
		if (flag) {
			return end - start;
		}
		int max = 0;
		for (int i = start; i < end; i++) {
			if (freq.get(chars[i]) < k) {
				max = Math.max(max, longestSubstring(chars, start, i, k));
				start = i + 1;
			}
		}
		max = Math.max(max, longestSubstring(chars, start, end, k));
		return max;
	}
}
