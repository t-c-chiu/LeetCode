package medium;

import java.util.Stack;

public class LongestAbsoluteFilePath {
	
	public static void main(String[] args) {
		int res = lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
		System.out.println(res);
	}
	
	public static int lengthLongestPath(String input) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		for (String s : input.split("\n")) {
			int level = s.lastIndexOf("\t") + 1;
			while (stack.size() > level) {
				stack.pop();
			}
			int len = s.length() - level;
			if (!stack.isEmpty()) {
				len += stack.peek();
			}
			if (s.contains(".")) {
				res = Math.max(res, len);
			} else {
				stack.push(len + 1);
			}
		}
		return res;
	}
	
}
