package medium;

import util.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreeFromString {
	
	public static void main(String[] args) {
		TreeNode res = str2tree("-4(2(3)(1))(6(5))");
		System.out.println(res);
	}
	
	public static TreeNode str2tree(String s) {
		TreeNode cur = null;
		Stack<TreeNode> stack = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c) || c == '-') {
				int start = i;
				while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
					i++;
				}
				cur = new TreeNode(Integer.parseInt(s.substring(start, i)));
				continue;
			}
			if (c == '(') {
				stack.push(cur);
			} else {
				TreeNode parent = stack.pop();
				if (parent.left == null) {
					parent.left = cur;
				} else {
					parent.right = cur;
				}
				cur = parent;
			}
			i++;
		}
		return cur;
	}
}
