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
		helper(res, map, root);
		return res;
	}
	
	private static String helper(List<TreeNode> res, Map<String, Integer> map, TreeNode node) {
		if (node == null) {
			return null;
		}
		String left = helper(res, map, node.left);
		String right = helper(res, map, node.right);
		String s = "(" + left + node.val + right + ")";
		if (map.containsKey(s) && map.get(s) == 1) {
			res.add(node);
		}
		map.put(s, map.getOrDefault(s, 0) + 1);
		return s;
	}
	
}
