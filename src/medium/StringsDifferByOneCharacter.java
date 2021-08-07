package medium;

import java.util.HashSet;
import java.util.Set;

public class StringsDifferByOneCharacter {
	
	public static void main(String[] args) {
		boolean res = differByOne(new String[]{"abcd", "cccc", "abyd", "abab"});
		System.out.println(res);
	}
	
	public static boolean differByOne(String[] dict) {
		Set<String> set = new HashSet<>();
		for (String s : dict) {
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				chars[i] = '*';
				if (!set.add(String.valueOf(chars))) {
					return true;
				}
				chars[i] = s.charAt(i);
			}
		}
		return false;
	}
	
}
