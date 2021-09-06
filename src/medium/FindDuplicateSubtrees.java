package medium;

import util.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {
	
	public static void main(String[] args) {
		List<TreeNode> res = findDuplicateSubtrees(
				TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4}));
		System.out.println(res);
	}
	
	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		serialize(root, map, res);
		return res;
	}
	
	private static String serialize(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
		if (node == null) {
			return "";
		}
		String s = "(" + serialize(node.left, map, res) + node.val + serialize(node.right, map, res) + ")";
		if (map.containsKey(s) && map.get(s) == 1) {
			res.add(node);
		}
		map.put(s, map.getOrDefault(s, 0) + 1);
		return s;
	}
}
