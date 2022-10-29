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
		List<String> list = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
		helper(res, digits, 0, list, "");
		return res;
	}
	
	private static void helper(List<String> res, String digits, int i, List<String> list, String temp) {
		if (i == digits.length()) {
			res.add(temp);
			return;
		}
		String s = list.get(digits.charAt(i) - '0');
		for (int j = 0; j < s.length(); j++) {
			helper(res, digits, i + 1, list, temp + s.charAt(j));
		}
	}
}
