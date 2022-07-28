package medium;

public class PalindromicSubstrings {
	
	public static void main(String[] args) {
		int res = countSubstrings("aaa");
		System.out.println(res);
	}
	
	public static int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0) {
				res += countSubstrings(s, i - 1, i);
			}
			res += countSubstrings(s, i, i);
		}
		return res;
	}
	
	private static int countSubstrings(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}
}
