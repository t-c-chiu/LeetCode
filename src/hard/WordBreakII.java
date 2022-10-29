package hard;

import java.util.*;

public class WordBreakII {
	
	public static void main(String[] args) {
		List<String> res = wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
		System.out.println(res);
	}
	
	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		helper(res, s, 0, new HashSet<>(wordDict), new ArrayList<>());
		return res;
	}
	
	private static void helper(List<String> res, String s, int start, Set<String> set, List<String> temp) {
		if (start == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String str : temp) {
				sb.append(str).append(" ");
			}
			res.add(sb.toString().trim());
			return;
		}
		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);
			if (set.contains(sub)) {
				temp.add(sub);
				helper(res, s, i + 1, set, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
}
