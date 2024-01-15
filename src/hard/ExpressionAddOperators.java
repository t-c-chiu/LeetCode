package hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	
	public static void main(String[] args) {
		List<String> res = addOperators("232", 8);
		System.out.println(res);
	}
	
	public static List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		helper(res, num, 0, target, "", 0, 0);
		return res;
	}
	
	private static void helper(List<String> res, String s, int pos, int target, String path, long num, long last) {
		if (pos == s.length()) {
			if (num == target) {
				res.add(path);
			}
			return;
		}
		for (int i = pos; i < s.length(); i++) {
			if (i != pos && s.charAt(pos) == '0') {
				break;
			}
			long cur = Long.parseLong(s.substring(pos, i + 1));
			if (path.isEmpty()) {
				helper(res, s, i + 1, target, String.valueOf(cur), cur, cur);
			} else {
				helper(res, s, i + 1, target, path + "+" + cur, num + cur, cur);
				helper(res, s, i + 1, target, path + "-" + cur, num - cur, -cur);
				helper(res, s, i + 1, target, path + "*" + cur, num - last + last * cur, last * cur);
			}
		}
	}
}
