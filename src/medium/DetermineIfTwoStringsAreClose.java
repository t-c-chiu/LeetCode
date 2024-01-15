package medium;

import java.util.HashMap;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {
	
	public static void main(String[] args) {
		boolean res = closeStrings("cabbba", "abbccc");
		System.out.println(res);
	}
	
	public static boolean closeStrings(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		if (m != n) {
			return false;
		}
		int[] count1 = new int[26];
		for (int i = 0; i < m; i++) {
			count1[word1.charAt(i) - 'a']++;
		}
		int[] count2 = new int[26];
		for (int i = 0; i < n; i++) {
			char c = word2.charAt(i);
			count2[c - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (count1[i] != 0 && count2[i] == 0 || count1[i] == 0 && count2[i] != 0) {
				return false;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : count1) {
			if (i > 0) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}
		for (int i : count2) {
			if (i > 0) {
				if (!map.containsKey(i) || map.get(i) <= 0) {
					return false;
				}
				map.put(i, map.get(i) - 1);
			}
		}
		return true;
	}
	
}
