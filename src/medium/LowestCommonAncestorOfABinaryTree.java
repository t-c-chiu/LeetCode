package medium;

import util.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		TreeNode res = lowestCommonAncestor(root, root.left.right.left, root.left.left);
		System.out.println(res);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		parent.put(root, null);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!parent.containsKey(p) || !parent.containsKey(q)) {
			TreeNode cur = queue.poll();
			if (cur.left != null) {
				parent.put(cur.left, cur);
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				parent.put(cur.right, cur);
				queue.offer(cur.right);
			}
		}
		Set<TreeNode> ancestors = new HashSet<>();
		while (p != null) {
			ancestors.add(p);
			p = parent.get(p);
		}
		while (!ancestors.contains(q)) {
			q = parent.get(q);
		}
		return q;
	}
//	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		if (root == null || root == p || root == q) {
//			return root;
//		}
//		TreeNode left = lowestCommonAncestor(root.left, p, q);
//		TreeNode right = lowestCommonAncestor(root.right, p, q);
//		if (left != null && right != null) {
//			return root;
//		}
//		return left == null ? right : left;
//	}
}
