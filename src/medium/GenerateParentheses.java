package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		System.out.println(res);
	}
	
	
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		backtrack(res, 0, 0, n, "");
		return res;
	}
	
	private static void backtrack(List<String> res, int open, int close, int n, String temp) {
		if (temp.length() == n * 2) {
			res.add(temp);
			return;
		}
		if (open < n) {
			backtrack(res, open + 1, close, n, temp + '(');
		}
		if (close < open) {
			backtrack(res, open, close + 1, n, temp + ')');
		}
	}
}
