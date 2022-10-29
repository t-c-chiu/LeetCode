package medium;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
	
	public static void main(String[] args) {
		int res = longestContinuousSubstring("abacaba");
		System.out.println(res);
	}
	
	public static int longestContinuousSubstring(String s) {
		int res = 1, len = 1;
		for (int i = 1; i < s.length(); i++) {
			char pre = s.charAt(i - 1), cur = s.charAt(i);
			if (cur == pre + 1) {
				res = Math.max(res, ++len);
			} else {
				len = 1;
			}
		}
		return res;
	}
}
