package medium;

import util.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
	
	public static void main(String[] args) {
		List<List<Integer>> res = verticalOrder(TreeNode.generateRoot(new Integer[]{3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5}));
		System.out.println(res);
	}
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> col = new LinkedList<>();
		queue.offer(root);
		col.offer(0);
		int min = 0, max = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			Integer c = col.poll();
			map.putIfAbsent(c, new ArrayList<>());
			map.get(c).add(node.val);
			min = Math.min(min, c);
			max = Math.max(max, c);
			if (node.left != null) {
				queue.offer(node.left);
				col.offer(c - 1);
			}
			if (node.right != null) {
				queue.offer(node.right);
				col.offer(c + 1);
			}
		}
		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}
		return res;
	}
	
}
