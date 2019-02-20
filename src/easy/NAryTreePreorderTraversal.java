package easy;

import java.util.ArrayList;
import java.util.List;

import util.Node;

public class NAryTreePreorderTraversal {
	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<>();
		helper(root, list);
		return list;
	}

	private void helper(Node node, List list) {
		if (node == null)
			return;
		list.add(node.val);
		for (Node child : node.children)
			helper(child, list);
	}
}
