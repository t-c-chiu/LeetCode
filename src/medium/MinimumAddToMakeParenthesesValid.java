package medium;

public class MinimumAddToMakeParenthesesValid {
	
	public static void main(String[] args) {
		System.out.println(minAddToMakeValid("())"));
		System.out.println(minAddToMakeValid("((("));
		System.out.println(minAddToMakeValid("()"));
		System.out.println(minAddToMakeValid("()))(("));
		System.out.println(minAddToMakeValid(")))()((("));
		System.out.println(minAddToMakeValid("))(()())("));
	}
	
	public static int minAddToMakeValid(String s) {
		int open = 0, close = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				open++;
			} else {
				if (open == 0) {
					close++;
				} else {
					open--;
				}
			}
		}
		return open + close;
	}
}
