package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	
	public static void main(String[] args) {
		List<List<String>> res = groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
		System.out.println(res);
	}
	
	public static List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		for (String string : strings) {
			char c = string.charAt(0);
			int shift = c - 'a';
			String key = shift(string, shift);
			map.putIfAbsent(key,new ArrayList<>());
			map.get(key).add(string);
		}
		List<List<String>> res = new ArrayList<>();
		for (String key : map.keySet()) {
			res.add(map.get(key));
		}
		return res;
	}
	
	private static String shift(String s, int shift) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			builder.append((c - shift + 26) % 26);
		}
		return builder.toString();
	}
}
