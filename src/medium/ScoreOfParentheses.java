package medium;

import java.util.Stack;

public class ScoreOfParentheses {
	
	public static void main(String[] args) {
//		System.out.println(scoreOfParentheses("()"));
//		System.out.println(scoreOfParentheses("(())"));
//		System.out.println(scoreOfParentheses("()()"));
		System.out.println(scoreOfParentheses("(()(()))"));
	}
	
	public static int scoreOfParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int score = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(score);
				score = 0;
			} else {
				score = stack.pop() + Math.max(1, score * 2);
			}
		}
		return score;
	}

//	public static int scoreOfParentheses(String s) {
//		int res = 0, count = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == '(') {
//				count++;
//			} else {
//				count--;
//				if (s.charAt(i - 1) == '(') {
//					res += (int) Math.pow(2, count);
//				}
//			}
//		}
//		return res;
//	}
	
}
