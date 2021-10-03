package medium;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	
	public static void main(String[] args) {
		int res = maxLength(Arrays.asList("cha", "r", "act", "ers"));
		System.out.println(res);
	}
	
	public static int maxLength(List<String> arr) {
		List<String> list = new ArrayList<>();
		list.add("");
		for (String s : arr) {
			if (!isUnique(s)) {
				continue;
			}
			List<String> temp = new ArrayList<>();
			for (String prevStr : list) {
				String newStr = prevStr + s;
				if (!isUnique(newStr)) {
					continue;
				}
				temp.add(newStr);
			}
			list.addAll(temp);
		}
		int res = 0;
		for (String s : list) {
			res = Math.max(res, s.length());
		}
		return res;
	}
	
	private static boolean isUnique(String s) {
		boolean[] used = new boolean[26];
		for (char c : s.toCharArray()) {
			if (used[c - 'a']) {
				return false;
			}
			used[c - 'a'] = true;
		}
		return true;
	}
}
