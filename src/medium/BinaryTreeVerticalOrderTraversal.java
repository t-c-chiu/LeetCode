package medium;

import util.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
	
	public static void main(String[] args) {
		List<List<Integer>> res = verticalOrder(util.TreeNode.generateRoot(new Integer[]{3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5}));
		System.out.println(res);
	}
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<TreeNodeWithCol> queue = new LinkedList<>();
		queue.offer(new TreeNodeWithCol(root, 0));
		int min = 0, max = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNodeWithCol node = queue.poll();
				TreeNode treeNode = node.node;
				map.putIfAbsent(node.col, new ArrayList<>());
				map.get(node.col).add(treeNode.val);
				
				if (treeNode.left != null) {
					queue.offer(new TreeNodeWithCol(treeNode.left, node.col - 1));
					min = Math.min(min, node.col - 1);
				}
				
				if (treeNode.right != null) {
					queue.offer(new TreeNodeWithCol(treeNode.right, node.col + 1));
					max = Math.max(max, node.col + 1);
				}
			}
		}
		
		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}
		return res;
	}
	
	static class TreeNodeWithCol {
		TreeNode node;
		int col;
		
		TreeNodeWithCol(TreeNode node, int col) {
			this.node = node;
			this.col = col;
		}
	}
	
}
