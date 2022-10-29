package medium;

public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
	
	public static void main(String[] args) {
		int res = minSwaps("111000");
		System.out.println(res);
	}
	
	public static int minSwaps(String s) {
		int zero = 0, one = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '0') {
				zero++;
			} else {
				one++;
			}
		}
		if (Math.abs(zero - one) > 1) {
			return -1;
		}
		if (zero > one) {
			return helper(chars, '0');
		} else if (one > zero) {
			return helper(chars, '1');
		} else {
			return Math.min(helper(chars, '0'), helper(chars, '1'));
		}
	}
	
	private static int helper(char[] chars, char expect) {
		int diff = 0;
		for (char c : chars) {
			if (c != expect) {
				diff++;
			}
			expect = expect == '0' ? '1' : '0';
		}
		return diff / 2;
	}
	
}
