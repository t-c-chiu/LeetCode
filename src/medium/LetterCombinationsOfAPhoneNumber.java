package medium;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
	
	public static void main(String[] args) {
		List<String> res = letterCombinations("23");
		System.out.println(res);
	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.isEmpty()) {
			return res;
		}
		String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		helper(res, map, digits, 0, "");
		return res;
	}
	
	private static void helper(List<String> res, String[] map, String digits, int i, String temp) {
		if (i == digits.length()) {
			res.add(temp);
			return;
		}
		for (char c : map[digits.charAt(i) - '0'].toCharArray()) {
			helper(res, map, digits, i + 1, temp + c);
		}
	}
}
