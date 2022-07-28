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
		helper(res, s, 0, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<String>> res, String s, int start, List<String> temp) {
		if (start == s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				helper(res, s, i + 1, temp);
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
