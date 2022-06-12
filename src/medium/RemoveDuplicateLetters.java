package medium;

import java.util.*;

public class RemoveDuplicateLetters {
	
	public static void main(String[] args) {
		String res = removeDuplicateLetters("cbadcbc");
		System.out.println(res);
	}
	
	public static String removeDuplicateLetters(String s) {
		int n = s.length();
		Map<Character, Integer> lastIndex = new HashMap<>();
		Set<Character> seen = new HashSet<>();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			lastIndex.put(s.charAt(i), i);
		}
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (seen.contains(c)) {
				continue;
			}
			while (!stack.isEmpty() && c < stack.peek() && lastIndex.get(stack.peek()) > i) {
				seen.remove(stack.pop());
			}
			seen.add(c);
			stack.add(c);
		}
		StringBuilder builder = new StringBuilder();
		for (Character c : stack) {
			builder.append(c);
		}
		return builder.toString();
	}
}
