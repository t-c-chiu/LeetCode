package easy;

import java.util.HashSet;
import java.util.Set;

public class MinimizeStringLength {
	
	public static void main(String[] args) {
	
	}
	
	public static int minimizedStringLength(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		return set.size();
	}
}
