package easy;

public class MinimumChangesToMakeAlternatingBinaryString {
	
	public static void main(String[] args) {
		int res = minOperations("0100");
		System.out.println(res);
	}
	
	public static int minOperations(String s) {
		return Math.min(helper(s, '0'), helper(s, '1'));
	}
	
	private static int helper(String s, char c) {
		int change = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != c) {
				change++;
			}
			c = c == '0' ? '1' : '0';
		}
		return change;
	}
	
}
