package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
	public static void main(String[] args) {
		DeleteNodesAndReturnForest test = new DeleteNodesAndReturnForest();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<TreeNode> treeNodes = test.delNodes(root, new int[]{3, 5});
		System.out.println(treeNodes);
	}
	
	private List<TreeNode> res = new ArrayList<>();
	private Set<Integer> toDelete = new HashSet<>();
	
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		for (int val : to_delete) {
			toDelete.add(val);
		}
		helper(root, true);
		return res;
	}
	
	private TreeNode helper(TreeNode node, boolean isRoot) {
		if (node == null)
			return null;
		boolean deleted = toDelete.contains(node.val);
		if (isRoot && !deleted)
			res.add(node);
		node.left = helper(node.left, deleted);
		node.right = helper(node.right, deleted);
		return deleted ? null : node;
	}
}
