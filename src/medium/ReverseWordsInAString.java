package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
	
	public static void main(String[] args) {
		String res = reverseWords("  Bob    Loves  Alice   ");
		System.out.println(res);
	}
	
	public static String reverseWords(String s) {
		List<String> list = Arrays.asList(s.trim().split("\\s+"));
		Collections.reverse(list);
		return String.join(" ", list);
	}
}
