package medium;

import util.TreeNode;

public class DeleteNodeInABST {
	
	public static void main(String[] args) {
		TreeNode res = deleteNode(TreeNode.generateRoot(new Integer[]{5, 3, 6, 2, 4, null, 7}), 3);
		System.out.println(res);
	}
	
	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			
			TreeNode next = findNext(root.right);
			root.val = next.val;
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}
	
	private static TreeNode findNext(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
