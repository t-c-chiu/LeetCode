package medium;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	
	public static void main(String[] args) {
		int res = maxLength(Arrays.asList("cha", "r", "act", "ers"));
		System.out.println(res);
	}
	
	static int res = 0;
	
	public static int maxLength(List<String> arr) {
		backtrack(arr, 0, "");
		return res;
	}
	
	private static void backtrack(List<String> arr, int start, String temp) {
		if (isUnique(temp)) {
			res = Math.max(res, temp.length());
		} else {
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			backtrack(arr, i + 1, temp + arr.get(i));
		}
	}
	
	private static boolean isUnique(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (!set.add(c)) {
				return false;
			}
		}
		return true;
	}
}
