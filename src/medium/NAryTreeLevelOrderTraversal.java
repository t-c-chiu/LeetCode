package medium;

import util.Node;

import java.util.*;

public class NAryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		add(root, res, 0);
		return res;
	}
	
	private void add(Node node, List<List<Integer>> res, int level) {
		if (node == null) {
			return;
		}
		
		if (res.size() == level) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(node.val);
		for (Node child : node.children) {
			add(child, res, level + 1);
		}
	}
}
