package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
	
	public static void main(String[] args) {
	
	}
	
	public boolean halvesAreAlike(String s) {
		int count = 0, n = s.length();
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		for (int i = 0; i < n / 2; i++) {
			if (set.contains(Character.toLowerCase(s.charAt(i)))) {
				count++;
			}
		}
		for (int i = n / 2; i < n; i++) {
			if (set.contains(Character.toLowerCase(s.charAt(i)))) {
				count--;
			}
		}
		return count == 0;
	}
}
