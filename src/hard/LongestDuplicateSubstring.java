package hard;

import java.util.HashSet;
import java.util.Set;

public class LongestDuplicateSubstring {
	
	public static void main(String[] args) {
		String res = longestDupSubstring("banana");
		System.out.println(res);
	}
	
	public static String longestDupSubstring(String s) {
		int n = s.length();
		for (int i = n - 1; i > 0; i--) {
			StringBuilder builder = new StringBuilder(s.substring(0, i));
			Set<String> seen = new HashSet<>();
			seen.add(builder.toString());
			for (int j = i; j < n; j++) {
				String temp = builder.deleteCharAt(0).append(s.charAt(j)).toString();
				if (seen.contains(temp)){
					return temp;
				}
				seen.add(temp);
			}
		}
		return "";
	}
}
