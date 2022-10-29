package easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	public static void main(String[] args) {
		IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
		System.out.println(isomorphicStrings.isIsomorphic("badc", "baba"));
	}
	
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> st = new HashMap<>();
		Map<Character, Character> ts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (!st.containsKey(sc) && !ts.containsKey(tc)) {
				st.put(sc, tc);
				ts.put(tc, sc);
			}
			if (!st.containsKey(sc) || st.get(sc) != tc || !ts.containsKey(tc) || ts.get(tc) != sc) {
				return false;
			}
		}
		return true;
	}
}
