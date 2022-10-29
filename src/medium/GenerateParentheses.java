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
		helper(res, n, 0, 0, "");
		return res;
	}
	
	private static void helper(List<String> res, int n, int open, int close, String temp) {
		if (temp.length() == n * 2) {
			res.add(temp);
			return;
		}
		if (open < n) {
			helper(res, n, open + 1, close, temp + '(');
		}
		if (close < open) {
			helper(res, n, open, close + 1, temp + ')');
		}
	}
	
}
