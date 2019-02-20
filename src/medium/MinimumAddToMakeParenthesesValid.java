package medium;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

	public static void main(String[] args) {
		MinimumAddToMakeParenthesesValid minimumAddToMakeParenthesesValid = new MinimumAddToMakeParenthesesValid();
		System.out.println(minimumAddToMakeParenthesesValid.minAddToMakeValid("())"));
		System.out.println(minimumAddToMakeParenthesesValid.minAddToMakeValid("((("));
		System.out.println(minimumAddToMakeParenthesesValid.minAddToMakeValid("()"));
		System.out.println(minimumAddToMakeParenthesesValid.minAddToMakeValid("()))(("));
		System.out.println(minimumAddToMakeParenthesesValid.minAddToMakeValid(")))()((("));
		System.out.println(minimumAddToMakeParenthesesValid.minAddToMakeValid("))(()())("));
	}

	public int minAddToMakeValid(String S) {
		int rightParenthesis = 0;
		Stack<Character> leftParenthesis = new Stack<>();
		for (char c : S.toCharArray()) {
			switch (c) {
				case '(':
					leftParenthesis.push(c);
					break;
				case ')':
					if (leftParenthesis.isEmpty())
						rightParenthesis++;
					else
						leftParenthesis.pop();
			}
		}
		return leftParenthesis.size() + rightParenthesis;
	}
}
