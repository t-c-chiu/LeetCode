package hard;

import util.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
	
	public static void main(String[] args) {
		List<List<Integer>> res = verticalTraversal(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
		System.out.println(res);
	}
	
	static int maxRow = Integer.MIN_VALUE;
	static int minCol = Integer.MAX_VALUE;
	static int maxCol = Integer.MIN_VALUE;
	
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
		helper(root, 0, 0, map);
		for (int i = minCol; i <= maxCol; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= maxRow; j++) {
				if (map.get(i).containsKey(j)) {
					List<Integer> temp = map.get(i).get(j);
					temp.sort(Comparator.naturalOrder());
					list.addAll(temp);
				}
			}
			res.add(list);
		}
		return res;
	}
	
	private static void helper(TreeNode node, int r, int c, Map<Integer, Map<Integer, List<Integer>>> map) {
		if (node == null) {
			return;
		}
		map.putIfAbsent(c, new HashMap<>());
		map.get(c).putIfAbsent(r, new ArrayList<>());
		map.get(c).get(r).add(node.val);
		maxRow = Math.max(maxRow, r);
		minCol = Math.min(minCol, c);
		maxCol = Math.max(maxCol, c);
		helper(node.left, r + 1, c - 1, map);
		helper(node.right, r + 1, c + 1, map);
	}
}
