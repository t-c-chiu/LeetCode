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
		Map<TreeNode, Integer> map = new HashMap<>();
		buildMap(root, target, map);
		List<Integer> res = new ArrayList<>();
		dfs(res, root, map, k, 0);
		return res;
	}
	
	private static void dfs(List<Integer> res, TreeNode node, Map<TreeNode, Integer> map, int k, int length) {
		if (node == null) {
			return;
		}
		if (map.containsKey(node)) {
			length = map.get(node);
		}
		if (length == k) {
			res.add(node.val);
		}
		dfs(res, node.left, map, k, length + 1);
		dfs(res, node.right, map, k, length + 1);
	}
	
	private static int buildMap(TreeNode node, TreeNode target, Map<TreeNode, Integer> map) {
		if (node == null) {
			return -1;
		}
		if (node == target) {
			map.put(node, 0);
			return 0;
		}
		int left = buildMap(node.left, target, map);
		if (left >= 0) {
			map.put(node, left + 1);
			return left + 1;
		}
		int right = buildMap(node.right, target, map);
		if (right >= 0) {
			map.put(node, right + 1);
			return right + 1;
		}
		return -1;
	}
//	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//		Map<TreeNode, Set<TreeNode>> g = new HashMap<>();
//		buildGraph(g, root, null);
//		Queue<TreeNode> q = new LinkedList<>();
//		q.offer(target);
//		while (!q.isEmpty() && k > 0) {
//			for (int i = q.size(); i > 0; i--) {
//				TreeNode cur = q.poll();
//				for (TreeNode next : g.get(cur)) {
//					g.get(next).remove(cur);
//					q.offer(next);
//				}
//			}
//			k--;
//		}
//		List<Integer> res = new ArrayList<>();
//		while (!q.isEmpty()) {
//			res.add(q.poll().val);
//		}
//		return res;
//	}
//
//	private static void buildGraph(Map<TreeNode, Set<TreeNode>> g, TreeNode node, TreeNode parent) {
//		if (node == null) {
//			return;
//		}
//		g.put(node, new HashSet<>());
//		if (parent != null) {
//			g.get(parent).add(node);
//			g.get(node).add(parent);
//		}
//		buildGraph(g, node.left, node);
//		buildGraph(g, node.right, node);
//	}
}
