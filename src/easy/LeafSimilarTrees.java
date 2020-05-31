package easy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(8);
		boolean result = new LeafSimilarTrees().leafSimilar(root, root);
		System.out.println(result);
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> root1Leafs = new ArrayList<>();
		List<Integer> root2Leafs = new ArrayList<>();
		loadLeafs(root1, root1Leafs);
		loadLeafs(root2, root2Leafs);
		return root1Leafs.equals(root2Leafs);
	}

	private void loadLeafs(TreeNode root, List<Integer> leafs) {
		if (root.left == null && root.right == null)
			leafs.add(root.val);

		if (root.left != null)
			loadLeafs(root.left, leafs);

		if (root.right != null)
			loadLeafs(root.right, leafs);
	}
}
