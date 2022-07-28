package medium;

import util.TreeNode;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
	
	public static void main(String[] args) {
		String res = getDirections(TreeNode.generateRoot(new Integer[]{5, 1, 2, 3, null, 6, 4}), 3, 6);
		System.out.println(res);
	}
	
	public static String getDirections(TreeNode root, int startValue, int destValue) {
		StringBuilder pathToStart = new StringBuilder(), pathToDest = new StringBuilder();
		find(root, startValue, pathToStart);
		find(root, destValue, pathToDest);
		int startLen = pathToStart.length(), destLen = pathToDest.length(), i = 0, min = Math.min(startLen, destLen);
		while (i < min && pathToStart.charAt(i) == pathToDest.charAt(i)) {
			i++;
		}
		return "U".repeat(startLen - i) + pathToDest.substring(i);
	}
	
	private static boolean find(TreeNode node, int val, StringBuilder path) {
		if (node == null) {
			return false;
		}
		if (node.val == val) {
			return true;
		}
		path.append('L');
		if (find(node.left, val, path)) {
			return true;
		}
		path.deleteCharAt(path.length() - 1);
		
		path.append('R');
		if (find(node.right, val, path)) {
			return true;
		}
		path.deleteCharAt(path.length() - 1);
		
		return false;
	}

//	public static String getDirections(TreeNode root, int startValue, int destValue) {
//		TreeNode LCA = LCA(root, startValue, destValue);
//		StringBuilder pathToStart = new StringBuilder(), pathToDest = new StringBuilder();
//		find(LCA, startValue, pathToStart, true);
//		find(LCA, destValue, pathToDest, false);
//		return pathToStart.append(pathToDest.reverse()).toString();
//	}
//
//	private static boolean find(TreeNode node, int val, StringBuilder path, boolean toStart) {
//		if (node == null) {
//			return false;
//		}
//		if (node.val == val) {
//			return true;
//		}
//		if (find(node.left, val, path, toStart)) {
//			path.append(toStart ? 'U' : 'L');
//			return true;
//		}
//		if (find(node.right, val, path, toStart)) {
//			path.append(toStart ? 'U' : 'R');
//			return true;
//		}
//		return false;
//	}
//
//	private static TreeNode LCA(TreeNode root, int p, int q) {
//		if (root == null || root.val == p || root.val == q) {
//			return root;
//		}
//		TreeNode left = LCA(root.left, p, q);
//		TreeNode right = LCA(root.right, p, q);
//		if (left != null && right != null) {
//			return root;
//		}
//		return left == null ? right : left;
//	}
	
}
