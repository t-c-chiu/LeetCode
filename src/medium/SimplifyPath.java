package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SimplifyPath {
	
	public static void main(String[] args) {
		String res = simplifyPath("/../");
		System.out.println(res);
	}
	
	public static String simplifyPath(String path) {
		String[] split = path.split("/");
		Stack<String> stack = new Stack<>();
		Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
		for (String s : split) {
			if ("..".equals(s) && !stack.isEmpty()) {
				stack.pop();
			} else if (!skip.contains(s)) {
				stack.push(s);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (String s : stack) {
			builder.append("/").append(s);
		}
		return builder.isEmpty() ? "/" : builder.toString();
	}
}
