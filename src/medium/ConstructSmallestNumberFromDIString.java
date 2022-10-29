package medium;

public class ConstructSmallestNumberFromDIString {
	
	public static void main(String[] args) {
		String res = smallestNumber("IIDD");
		System.out.println(res);
	}
	
	/**
	 * DDDII 432156
	 * IIDD 12543
	 * DIDI 21435
	 */
	public static String smallestNumber(String pattern) {
		int n = pattern.length();
		StringBuilder res = new StringBuilder(), stack = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			stack.append((char) ('1' + i));
			if (i == n || pattern.charAt(i) == 'I') {
				res.append(stack.reverse());
				stack = new StringBuilder();
			}
		}
		return res.toString();
	}
	
}
