package medium;

import java.util.Stack;

public class RemoveNthNodeFromEndOfList {
	
	public static void main(String[] args) {
		String s = simplifyPath("/home/");
		System.out.println(s);
		s = simplifyPath("/../");
		System.out.println(s);
		s = simplifyPath("/home//foo/");
		System.out.println(s);
		s = simplifyPath("/a/./b/../../c/");
		System.out.println(s);
	}
	
	static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] arr = path.split("/");
		for (String s : arr) {
			if (s.isEmpty() || s.equals(".")) {
				continue;
			}
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}
		StringBuilder sb = new StringBuilder("/");
		for (String s : stack) {
			sb.append(s).append("/");
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
