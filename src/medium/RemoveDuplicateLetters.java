package medium;

import java.util.*;

public class RemoveDuplicateLetters {
	
	public static void main(String[] args) {
		String res = removeDuplicateLetters("cbadcbc");
		System.out.println(res);
	}
	
	public static String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		Set<Character> seen = new HashSet<>();
		int n = s.length();
		int[] last = new int[26];
		for (int i = 0; i < n; i++) {
			last[s.charAt(i) - 'a'] = i;
		}
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (seen.contains(c)) {
				continue;
			}
			while (!stack.isEmpty() && c < stack.peek() && last[stack.peek() - 'a'] > i) {
				seen.remove(stack.pop());
			}
			seen.add(c);
			stack.push(c);
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}
}
