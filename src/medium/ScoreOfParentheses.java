package medium;

public class ScoreOfParentheses {
	
	public static void main(String[] args) {
		ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
		System.out.println(scoreOfParentheses.scoreOfParentheses("()"));
		System.out.println(scoreOfParentheses.scoreOfParentheses("(())"));
		System.out.println(scoreOfParentheses.scoreOfParentheses("()()"));
		System.out.println(scoreOfParentheses.scoreOfParentheses("(()(()))"));
	}
	
	// () = 1
	// (()) = 1 * 2 = 2
	// ()() = 1 + 1 = 2
	// (()(())) = (1 + (1 * 2)) * 2 = 6
	public int scoreOfParentheses(String S) {
		int ans = 0;
		int counter = 0;
		int leftStart = 0;
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
				case '(':
					if (counter++ == 0)
						leftStart = i;
					break;
				case ')':
					if (--counter == 0)
						ans += Math.max(2 * scoreOfParentheses(S.substring(leftStart + 1, i)), 1);
			}
		}
		return ans;
	}
}
