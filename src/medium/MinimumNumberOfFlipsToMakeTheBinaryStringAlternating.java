package medium;

public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {
	
	public static void main(String[] args) {
		int res = minFlips("111000");
		System.out.println(res);
	}
	
	/**
	 * 111000111000
	 */
	public static int minFlips(String s) {
		int n = s.length();
		s += s;
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			s1.append(i % 2 == 0 ? '0' : '1');
			s2.append(i % 2 == 0 ? '1' : '0');
		}
		int flip1 = 0, flip2 = 0, res = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s1.charAt(i) != s.charAt(i)) {
				++flip1;
			}
			if (s2.charAt(i) != s.charAt(i)) {
				++flip2;
			}
			if (i >= n) { //the most left element is outside of sliding window, we need to subtract the res if we did `flip` before.
				if (s1.charAt(i - n) != s.charAt(i - n)) {
					--flip1;
				}
				if (s2.charAt(i - n) != s.charAt(i - n)) {
					--flip2;
				}
			}
			if (i >= n - 1)
				res = Math.min(res, Math.min(flip1, flip2));
		}
		return res;
	}
}
