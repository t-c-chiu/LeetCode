package medium;

import java.util.Stack;

public class UsingARobotToPrintTheLexicographicallySmallestString {
	
	public static void main(String[] args) {
		String res = robotWithString("zza");
		System.out.println(res);
	}
	
	public static String robotWithString(String s) {
		Stack<Integer> stack = new Stack<>();
		int n = s.length();
		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			stack.push(i);
			count[s.charAt(i) - 'a']--;
			while (!stack.isEmpty() && isSmallest(s.charAt(stack.peek()), count)) {
				char c = s.charAt(stack.pop());
				builder.append(c);
			}
		}
		while (!stack.isEmpty()) {
			builder.append(s.charAt(stack.pop()));
		}
		return builder.toString();
	}
	
	private static boolean isSmallest(char c, int[] count) {
		for (int i = c - 1 - 'a'; i >= 0; i--) {
			if (count[i] > 0) {
				return false;
			}
		}
		return true;
	}
}
