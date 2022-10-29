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
	
	/**
	 * abc 012 bcd 123 xyz 23 24 25
	 */
	public static List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		for (String string : strings) {
			int offset = string.charAt(0) - 'a';
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < string.length(); i++) {
				char c = (char) (string.charAt(i) - offset);
				if (c < 'a') {
					c += 26;
				}
				sb.append(c);
			}
			String key = sb.toString();
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(string);
		}
		return new ArrayList<>(map.values());
	}
	
}
