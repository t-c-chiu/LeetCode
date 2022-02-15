package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	public static void main(String[] args) {
		List<List<String>> res = partition("aab");
		System.out.println(res);
	}
	
	
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), s, 0);
		return res;
	}
	
	private static void backtrack(List<List<String>> res, List<String> temp, String s, int start) {
		if (start == s.length()) {
			res.add(new ArrayList<>(temp));
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				backtrack(res, temp, s, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	private static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
}
