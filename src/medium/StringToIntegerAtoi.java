package medium;

public class StringToIntegerAtoi {
	
	public static void main(String[] args) {
		int res = myAtoi("4193 with words");
		System.out.println(res);
		res = myAtoi("words and 987");
		System.out.println(res);
		res = myAtoi("   -42");
		System.out.println(res);
		res = myAtoi("9223372036854775808");
		System.out.println(res);
	}
	
	public static int myAtoi(String s) {
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		if (i == n) {
			return 0;
		}
		boolean positive = s.charAt(i) != '-';
		if (s.charAt(i) == '+' || s.charAt(i) == '-') {
			i++;
		}
		long res = 0;
		while (i < n && Character.isDigit(s.charAt(i))) {
			res = res * 10 + s.charAt(i) - '0';
			if (positive && res > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (!positive && -res < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			i++;
		}
		return (int) (positive ? res : -res);
	}
}
