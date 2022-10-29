package easy;

import util.TreeNode;

public class ConstructStringFromBinaryTree {
	
	public static void main(String[] args) {
		String res = tree2str(TreeNode.generateRoot(new Integer[]{1, 2, 3, null, 4}));
		System.out.println(res);
	}
	
	public static String tree2str(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		tree2str(root, builder);
		return builder.toString();
	}
	
	private static void tree2str(TreeNode node, StringBuilder builder) {
		if (node == null) {
			return;
		}
		builder.append(node.val);
		if (node.left == null && node.right == null) {
			return;
		}
		builder.append('(');
		tree2str(node.left, builder);
		builder.append(')');
		if (node.right != null) {
			builder.append('(');
			tree2str(node.right, builder);
			builder.append(')');
		}
	}
	
}
