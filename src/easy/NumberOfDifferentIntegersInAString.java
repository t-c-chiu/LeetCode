package easy;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInAString {
	
	public static void main(String[] args) {
		int res = numDifferentIntegers("a123bc34d8ef34");
		System.out.println(res);
	}
	
	public static int numDifferentIntegers(String word) {
		Set<String> set = new HashSet<>();
		int i = 0;
		while (i < word.length()) {
			if (Character.isDigit(word.charAt(i))) {
				StringBuilder sb = new StringBuilder();
				while (i < word.length() && Character.isDigit(word.charAt(i))) {
					if (sb.length() > 0 || word.charAt(i) != '0') {
						sb.append(word.charAt(i));
					}
					i++;
				}
				set.add(sb.toString());
			} else {
				i++;
			}
		}
		return set.size();
	}
}
