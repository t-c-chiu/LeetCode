package easy;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToAppearTwice {
	
	public static void main(String[] args) {
	
	}
	
	public static char repeatedCharacter(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				return s.charAt(i);
			}
		}
		return ' ';
	}
}
