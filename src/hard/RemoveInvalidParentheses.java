package hard;

import java.util.*;

public class RemoveInvalidParentheses {
	
	public static void main(String[] args) {
		List<String> res = removeInvalidParentheses("(a)())()");
		System.out.println(res);
	}
	
	public static List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		Set<String> seen = new HashSet<>();
		seen.add(s);
		Queue<String> queue = new LinkedList<>();
		queue.offer(s);
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				String poll = queue.poll();
				if (isValid(poll)) {
					res.add(poll);
				}
				if (!res.isEmpty()) {
					continue;
				}
				for (int j = 0; j < poll.length(); j++) {
					char c = s.charAt(j);
					if (c == '(' || c == ')') {
						String next = poll.substring(0, j) + poll.substring(j + 1);
						if (seen.contains(next)) {
							continue;
						}
						seen.add(next);
						queue.offer(next);
					}
				}
			}
			if (!res.isEmpty()) {
				break;
			}
		}
		return res;
	}
	
	private static boolean isValid(String s) {
		int open = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				open++;
			}
			if (c == ')') {
				open--;
				if (open < 0) {
					return false;
				}
			}
		}
		return open == 0;
	}
	
}
