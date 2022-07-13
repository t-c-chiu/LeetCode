package medium;

public class CheckIfAParenthesesStringCanBeValid {
	
	public static void main(String[] args) {
		boolean res = canBeValid("()", "11");
		System.out.println(res);
	}
	
	public static boolean canBeValid(String s, String locked) {
		int n = s.length(), open = 0, close = 0;
		if (n % 2 == 1) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == ')' && locked.charAt(i) == '1') {
				close++;
			} else {
				open++;
			}
			if (close > open) {
				return false;
			}
		}
		open = 0;
		close = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '(' && locked.charAt(i) == '1') {
				open++;
			} else {
				close++;
			}
			if (open > close) {
				return false;
			}
		}
		return true;
	}
}
