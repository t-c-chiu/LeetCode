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
		helper(res, "", n, 0, 0);
		return res;
	}
	
	private static void helper(List<String> res, String temp, int n, int open, int close) {
		if (temp.length() == n * 2) {
			res.add(temp);
		}
		if (open < n) {
			helper(res, temp + "(", n, open + 1, close);
		}
		if (close < open) {
			helper(res, temp + ")", n, open, close + 1);
		}
	}
	
}
