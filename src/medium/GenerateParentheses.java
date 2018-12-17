package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis(4));
	}
	
	private List<String> result = new ArrayList<>();
	
	public List<String> generateParenthesis(int n) {
		helper(0, 0, n, "");
		return result;
	}
	
	private void helper(int left, int right, int n, String string) {
		if (left == n && right == n) {
			result.add(string);
			return;
		}
		if (left > n || right > n || right > left)
			return;
		
		helper(left + 1, right, n, string.concat("("));
		helper(left, right + 1, n, string.concat(")"));
	}
}
