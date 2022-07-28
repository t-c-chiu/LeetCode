package medium;

import util.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
	
	public static void main(String[] args) {
		List<List<Integer>> res = verticalOrder(TreeNode.generateRoot(new Integer[]{3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5}));
		System.out.println(res);
	}
	
	
	static int min, max;
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		findRange(root, 0);
		for (int i = min; i <= max; i++) {
			res.add(new ArrayList<>());
		}
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> idx = new LinkedList<>();
		q.offer(root);
		idx.offer(-min);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int i = idx.poll();
			res.get(i).add(node.val);
			if (node.left != null) {
				q.offer(node.left);
				idx.offer(i - 1);
			}
			if (node.right != null) {
				q.offer(node.right);
				idx.offer(i + 1);
			}
		}
		return res;
	}
	
	private static void findRange(TreeNode root, int i) {
		if (root == null) {
			return;
		}
		min = Math.min(min, i);
		max = Math.max(max, i);
		findRange(root.left, i - 1);
		findRange(root.right, i + 1);
	}
	
	
}
