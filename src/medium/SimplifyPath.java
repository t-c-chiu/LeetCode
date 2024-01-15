package medium;

import java.util.Stack;

public class SimplifyPath {
	
	public static void main(String[] args) {
		String res = simplifyPath("/../");
		System.out.println(res);
	}
	
	public static String simplifyPath(String path) {
		String[] split = path.split("/");
		Stack<String> stack = new Stack<>();
		for (String s : split) {
			if (s.isEmpty() || ".".equals(s)) {
				continue;
			}
			if ("..".equals(s)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		StringBuilder builder = new StringBuilder();
		for (String s : stack) {
			builder.append("/").append(s);
		}
		return builder.toString();
	}
}
