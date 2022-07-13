package medium;

public class DecodedStringAtIndex {
	
	public static void main(String[] args) {
		String res = decodeAtIndex("leet2code3", 10);
		System.out.println(res);
	}
	
	public static String decodeAtIndex(String s, int k) {
		long n = 0;
		int i;
		for (i = 0; n < k; i++) {
			char c = s.charAt(i);
			n = Character.isDigit(c) ? n * (c - '0') : n + 1;
		}
		for (i--; i > 0; i--) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				n /= c - '0';
				k %= n;
			} else {
				if (k % n == 0) {
					break;
				}
				n--;
			}
		}
		return String.valueOf(s.charAt(i));
	}
}
