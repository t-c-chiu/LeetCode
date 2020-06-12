package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Balance_a_Binary_Search_Tree {
	
	public static void main(String[] args) {
		Balance_a_Binary_Search_Tree test = new Balance_a_Binary_Search_Tree();
		TreeNode res = test.balanceBST(TreeNode.generateRoot(new Integer[]{1, null, 2, null, 3, null, 4, null, null}));
		System.out.println(res);
	}
	
	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> sortedTree = new ArrayList<>();
		sort(root, sortedTree);
		
		if (sortedTree.isEmpty()) {
			return null;
		}
		return generateBalancedBST(0, sortedTree.size() - 1, sortedTree);
	}
	
	private TreeNode generateBalancedBST(int start, int end, List<TreeNode> nodes) {
		if (start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode node = nodes.get(mid);
		node.left = generateBalancedBST(start, mid - 1, nodes);
		node.right = generateBalancedBST(mid + 1, end, nodes);
		return node;
	}
	
	private void sort(TreeNode root, List<TreeNode> nodes) {
		if (root == null) {
			return;
		}
		
		sort(root.left, nodes);
		nodes.add(root);
		sort(root.right, nodes);
	}
}
