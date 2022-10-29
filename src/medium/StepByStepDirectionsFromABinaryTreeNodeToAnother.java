package medium;

import util.TreeNode;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
	
	public static void main(String[] args) {
		String res = getDirections(TreeNode.generateRoot(new Integer[]{5, 1, 2, 3, null, 6, 4}), 3, 6);
		System.out.println(res);
	}
	
	public static String getDirections(TreeNode root, int startValue, int destValue) {
		StringBuilder startPath = new StringBuilder();
		find(root, startValue, startPath);
		StringBuilder destPath = new StringBuilder();
		find(root, destValue, destPath);
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while (i < Math.min(startPath.length(), destPath.length()) && startPath.charAt(i) == destPath.charAt(i)) {
			i++;
		}
		builder.append("U".repeat(startPath.length() - i)).append(destPath.substring(i));
		return builder.toString();
	}
	
	private static boolean find(TreeNode node, int value, StringBuilder path) {
		if (node == null) {
			return false;
		}
		if (node.val == value) {
			return true;
		}
		path.append("L");
		if (find(node.left, value, path)) {
			return true;
		}
		path.deleteCharAt(path.length() - 1);
		path.append("R");
		if (find(node.right, value, path)) {
			return true;
		}
		path.deleteCharAt(path.length() - 1);
		return false;
	}
	
}
