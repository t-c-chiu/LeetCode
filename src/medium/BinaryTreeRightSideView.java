package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	
	public static void main(String[] args) {
		List<Integer> res = rightSideView(TreeNode.generateRoot(new Integer[]{1, 2, 3, null, 5, null, 4}));
		System.out.println(res);
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			res.add(queue.peek().val);
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
			}
		}
		return res;
	}

//	public static List<Integer> rightSideView(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		dfs(root, res, 0);
//		return res;
//	}
//
//	private static void dfs(TreeNode node, List<Integer> res, int depth) {
//		if (node == null) {
//			return;
//		}
//		if (res.size() == depth) {
//			res.add(node.val);
//		}
//		dfs(node.right, res, depth + 1);
//		dfs(node.left, res, depth + 1);
//	}
	
}
