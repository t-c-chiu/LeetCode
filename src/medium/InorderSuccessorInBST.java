package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InorderSuccessorInBST {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{5, 3, 6, 2, 4, null, null, 1,null});
		assert root != null;
		TreeNode res = inorderSuccessor(root, root.left.left);
		System.out.println(res);
	}
	
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode successor = null;
		while (root != null) {
			if (root.val <= p.val) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}

//	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//		Queue<TreeNode> queue = new LinkedList<>();
//		build(queue, root);
//		while (!queue.isEmpty()) {
//			if (queue.poll() == p) {
//				return queue.peek();
//			}
//		}
//		return null;
//	}
//
//	private static void build(Queue<TreeNode> queue, TreeNode node) {
//		if (node == null) {
//			return;
//		}
//		build(queue, node.left);
//		queue.offer(node);
//		build(queue, node.right);
//	}
}
