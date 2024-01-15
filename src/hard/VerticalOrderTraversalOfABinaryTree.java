package hard;

import util.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
	
	public static void main(String[] args) {
		List<List<Integer>> res = verticalTraversal(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 6, 5, 7}));
		System.out.println(res);
	}
	
	static public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
		int minCol = 0, maxCol = 0, maxRow = 0;
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		nodes.offer(root);
		cols.offer(0);
		while (!nodes.isEmpty()) {
			for (int i = nodes.size(); i > 0; i--) {
				TreeNode node = nodes.poll();
				Integer col = cols.poll();
				minCol = Math.min(minCol, col);
				maxCol = Math.max(maxCol, col);
				map.putIfAbsent(col, new HashMap<>());
				map.get(col).putIfAbsent(maxRow, new ArrayList<>());
				map.get(col).get(maxRow).add(node.val);
				if (node.left != null) {
					nodes.offer(node.left);
					cols.offer(col - 1);
				}
				if (node.right != null) {
					nodes.offer(node.right);
					cols.offer(col + 1);
				}
			}
			maxRow++;
		}
		for (int i = minCol; i <= maxCol; i++) {
			Map<Integer, List<Integer>> rows = map.get(i);
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= maxRow; j++) {
				if (rows.containsKey(j)) {
					List<Integer> temp = rows.get(j);
					temp.sort(Comparator.naturalOrder());
					list.addAll(temp);
				}
			}
			res.add(list);
		}
		return res;
	}
	
}
