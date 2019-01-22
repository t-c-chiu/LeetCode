package easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
		System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
		System.out.println(isomorphicStrings.isIsomorphic("foo", "bar"));
		System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
	}

	//	Input: s = "egg", t = "add"
	//	Output: true
	//
	//	Input: s = "foo", t = "bar"
	//	Output: false
	//
	//	Input: s = "paper", t = "title"
	//	Output: true
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i), c2 = t.charAt(i);
			if (map.containsKey(c1)) {
				if (map.get(c1) != c2)
					return false;
			} else {
				if (map.containsValue(c2))
					return false;
				else
					map.put(c1, c2);
			}
		}
		return true;
	}
}
