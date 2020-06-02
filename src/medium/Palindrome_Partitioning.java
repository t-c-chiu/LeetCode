package medium;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
	
	public static void main(String[] args) {
		Palindrome_Partitioning test = new Palindrome_Partitioning();
		List<List<String>> res = test.partition("aab");
		System.out.println(res);
	}
	
	private List<List<String>> resultLst;
	private List<String> currLst;
	
	public List<List<String>> partition(String s) {
		resultLst = new ArrayList<>();
		currLst = new ArrayList<>();
		backTrack(s, 0);
		return resultLst;
	}
	
	public void backTrack(String s, int l) {
		if (l >= s.length()) {
			resultLst.add((new ArrayList<>(currLst)));
		}
		for (int i = l; i < s.length(); i++) {
			if (isPalindrome(s, l, i)) {
				if (l == i) {
					currLst.add(Character.toString(s.charAt(i)));
				} else {
					currLst.add(s.substring(l, i + 1));
				}
				backTrack(s, i + 1);
				currLst.remove(currLst.size() - 1);
			}
		}
	}
	
	public boolean isPalindrome(String str, int l, int r) {
		if (l == r) {
			return true;
		}
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
