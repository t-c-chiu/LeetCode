package medium;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
	
	public static void main(String[] args) {
		List<String> res = letterCombinations("");
		System.out.println(res);
	}
	
	public static List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> res = new ArrayList<>();
		backtrack(res, digits, 0, map, "");
		return res;
	}
	
	private static void backtrack(List<String> res, String digits, int i, String[] map, String temp) {
		if (i == digits.length()) {
			res.add(temp);
			return;
		}
		for (Character c : map[digits.charAt(i) - '0'].toCharArray()) {
			backtrack(res, digits, i + 1, map, temp + c);
		}
	}
}
