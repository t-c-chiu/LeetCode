package medium;

import util.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		List<Integer> res = distanceK(root, root.left, 2);
		System.out.println(res);
	}
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, Set<TreeNode>> g = new HashMap<>();
		buildGraph(g, root, null);
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(target);
		while (!q.isEmpty() && k > 0) {
			for (int i = q.size(); i > 0; i--) {
				TreeNode cur = q.poll();
				for (TreeNode next : g.get(cur)) {
					g.get(next).remove(cur);
					q.offer(next);
				}
			}
			k--;
		}
		List<Integer> res = new ArrayList<>();
		while (!q.isEmpty()) {
			res.add(q.poll().val);
		}
		return res;
	}

	private static void buildGraph(Map<TreeNode, Set<TreeNode>> g, TreeNode node, TreeNode parent) {
		if (node == null) {
			return;
		}
		g.put(node, new HashSet<>());
		if (parent != null) {
			g.get(parent).add(node);
			g.get(node).add(parent);
		}
		buildGraph(g, node.left, node);
		buildGraph(g, node.right, node);
	}
}
