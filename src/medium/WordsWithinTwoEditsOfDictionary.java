package medium;

import java.util.*;

public class WordsWithinTwoEditsOfDictionary {
	
	public static void main(String[] args) {
		List<String> res = twoEditWords(new String[]{"word", "note", "ants", "wood"}, new String[]{"wood", "joke", "moat"});
		System.out.println(res);
	}
	
	public static List<String> twoEditWords(String[] queries, String[] dictionary) {
		List<String> res = new ArrayList<>();
		for (String query : queries) {
			for (String target : dictionary) {
				if (canEdit(query, target)) {
					res.add(query);
					break;
				}
			}
		}
		return res;
	}
	
	private static boolean canEdit(String query, String target) {
		int edit = 0, n = query.length();
		for (int i = 0; i < n; i++) {
			if (query.charAt(i) != target.charAt(i)) {
				edit++;
			}
			if (edit > 2) {
				return false;
			}
		}
		return true;
	}
	
}
