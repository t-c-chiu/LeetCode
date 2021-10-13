package medium;

import util.TreeNode;

public class FindNearestRightNodeInBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{1, 2, 3, null, 4, 5, 6});
		TreeNode res = findNearestRightNode(root, root.left.right);
		System.out.println(res);
	}
	
	static int targetDepth = -1;
	
	public static TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
		return dfs(root, u, 0);
	}
	
	private static TreeNode dfs(TreeNode node, TreeNode target, int curDepth) {
		if (node == null) {
			return null;
		} else if (node == target) {
			targetDepth = curDepth;
		} else if (curDepth == targetDepth) {
			return node;
		}
		TreeNode n = dfs(node.left, target, curDepth + 1);
		if (n != null) {
			return n;
		}
		return dfs(node.right, target, curDepth + 1);
	}

//	public static TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			for (int i = 0; i < size; i++) {
//				TreeNode node = queue.poll();
//				if (node == u) {
//					return i == size - 1 ? null : queue.peek();
//				}
//				if (node.left != null) {
//					queue.offer(node.left);
//				}
//				if (node.right != null) {
//					queue.offer(node.right);
//				}
//			}
//		}
//		return null;
//	}
}
