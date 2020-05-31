package easy;

import util.TreeNode;

import java.util.*;

public class CousinsInBinaryTree {
	
	public static void main(String[] args) {
		CousinsInBinaryTree test = new CousinsInBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(test.isCousins(root, 2, 3));
		System.out.println(test.isCousins(root, 4, 5));
	}
	
	private int xDepth = -1;
	private int yDepth = -1;
	private TreeNode xParent;
	private TreeNode yParent;
	
	// DFS
	public boolean isCousins(TreeNode root, int x, int y) {
		helper(root, x, y, 1);
		return xDepth == yDepth && xParent != yParent;
	}
	
	private void helper(TreeNode node, int x, int y, int depth) {
		if (node == null)
			return;
		
		TreeNode left = node.left;
		TreeNode right = node.right;
		if (left != null) {
			if (left.val == x) {
				xDepth = depth;
				xParent = node;
			} else if (left.val == y) {
				yDepth = depth;
				yParent = node;
			}
		}
		if (right != null) {
			if (right.val == x) {
				xDepth = depth;
				xParent = node;
			} else if (right.val == y) {
				yDepth = depth;
				yParent = node;
			}
		}
		
		helper(left, x, y, depth + 1);
		helper(right, x, y, depth + 1);
	}
	
	// BFS
//	public boolean isCousins(TreeNode root, int x, int y) {
//		if (root == null)
//			return false;
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.add(root);
//		while (!queue.isEmpty()) {
//			TreeNode xParent = null, yParent = null;
//			int size = queue.size();
//			for (int i = 0; i < size; i++) {
//				TreeNode node = queue.poll();
//				TreeNode left = node.left;
//				TreeNode right = node.right;
//				if (left != null) {
//					if (left.val == x)
//						xParent = node;
//					else if (left.val == y)
//						yParent = node;
//					queue.add(left);
//				}
//				if (right != null) {
//					if (right.val == x)
//						xParent = node;
//					else if (right.val == y)
//						yParent = node;
//					queue.add(right);
//				}
//				if (xParent != null && yParent != null)
//					return xParent != yParent;
//			}
//		}
//		return false;
//	}
}
