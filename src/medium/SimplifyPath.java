package medium;

import java.util.*;

public class SimplifyPath {
	
	public static void main(String[] args) {
		String res = simplifyPath("/../");
		System.out.println(res);
	}
	
	public static String simplifyPath(String path) {
		String[] paths = path.split("/");
		Set<String> skip = new HashSet<>(Arrays.asList(".", "..", ""));
		Stack<String> stack = new Stack<>();
		for (String s : paths) {
			if (s.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!skip.contains(s)) {
				stack.push(s);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (String s : stack) {
			builder.append("/").append(s);
		}
		return stack.isEmpty() ? "/" : builder.toString();
	}

//	public static String simplifyPath(String path) {
//		String[] paths = path.split("/");
//		Map<String, String> map = new HashMap<>();
//		String root = "/";
//		map.put(root, root);
//		String cur = root;
//		for (int i = 1; i < paths.length; i++) {
//			String name = paths[i];
//			switch (name) {
//				case ".":
//					continue;
//				case "..":
//					cur = map.get(cur);
//					continue;
//				default:
//					String newPath = cur.equals(root) ? cur + name : cur + "/" + name;
//					map.put(newPath, cur);
//					cur = newPath;
//			}
//		}
//		return cur;
//	}
}
