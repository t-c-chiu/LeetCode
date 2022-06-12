package medium;

public class PalindromicSubstrings {
	
	public static void main(String[] args) {
		int res = countSubstrings("aabbaa");
		System.out.println(res);
	}
	
	public static int countSubstrings(String s) {
		int n = s.length(), res = 0;
		for (int i = 0; i < n; i++) {
			res += countPalindrome(s, i, i);
			res += countPalindrome(s, i, i + 1);
		}
		return res;
	}
	
	private static int countPalindrome(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}
	
}
