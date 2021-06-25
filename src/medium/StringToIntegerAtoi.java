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
	
	public static int myAtoi(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		
		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		
		if (i == str.length()) {
			return 0;
		}
		
		int sign = 1;
		char signChar = str.charAt(i);
		if (signChar == '+' || signChar == '-') {
			sign = signChar == '+' ? 1 : -1;
			i++;
		}
		
		int res = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			if (!Character.isDigit(c)) {
				break;
			}
			
			int digit = c - '0';
			if ((Integer.MAX_VALUE - digit) / 10 < res) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + digit;
			i++;
		}
		
		return res * sign;
	}
}
