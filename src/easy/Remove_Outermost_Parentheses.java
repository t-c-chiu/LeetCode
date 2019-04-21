package easy;

public class Remove_Outermost_Parentheses {
	
	public static void main(String[] args) {
		Remove_Outermost_Parentheses test = new Remove_Outermost_Parentheses();
		System.out.println(test.removeOuterParentheses("(()())(())"));
		System.out.println(test.removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(test.removeOuterParentheses("()()"));
	}
	
	public String removeOuterParentheses(String S) {
		int open = 0;
		StringBuilder builder = new StringBuilder();
		for (char c : S.toCharArray()) {
			if (c == '(') {
				if (open++ > 0)
					builder.append(c);
			} else {
				if (open-- > 1)
					builder.append(c);
			}
		}
		return builder.toString();
	}
}
