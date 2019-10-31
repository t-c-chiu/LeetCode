package medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
		test.letterCombinations("234").forEach(System.out::println);
	}
	
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<>();
		
		String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> res = new ArrayList<>();
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			List<String> next = new ArrayList<>();
			String letters = map[Character.getNumericValue(digits.charAt(i))];
			for (String prevStr : res) {
				for (int j = 0; j < letters.length(); j++) {
					next.add(prevStr + letters.charAt(j));
				}
			}
			res = next;
		}
		return res;
	}
}
