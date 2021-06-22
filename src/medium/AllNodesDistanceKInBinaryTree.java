package medium;

import util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesDistanceKInBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		List<Integer> res = distanceK(root, root.left, 2);
		System.out.println(res);
	}
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, List<TreeNode>> map = new HashMap<>();
		buildGraph(root, null, map);
		
		Queue<TreeNode> queue = new LinkedList<>();
		Set<TreeNode> visited = new HashSet<>();
		queue.offer(target);
		visited.add(target);
		while (!queue.isEmpty() && k > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				for (TreeNode next : map.get(node)) {
					if (!visited.contains(next)) {
						visited.add(next);
						queue.offer(next);
					}
				}
			}
			k--;
		}
		return queue.stream().map(t -> t.val).collect(Collectors.toList());
	}
	
	private static void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {
		if (node == null) {
			return;
		}
		map.putIfAbsent(node, new ArrayList<>());
		if (parent != null) {
			map.get(node).add(parent);
			map.get(parent).add(node);
		}
		buildGraph(node.left, node, map);
		buildGraph(node.right, node, map);
	}
	
}
