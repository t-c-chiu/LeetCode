package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		left.left = new TreeNode(1);
		left.right = new TreeNode(3);
		right.right = new TreeNode(1);
		root.left = left;
		root.right = right;
		System.out.println(new HouseRobberIII().rob(root));
	}
	
	//      3
	//     / \
	//	  4   5
	//	 / \   \
	//	1   3   1
	private Map<TreeNode, Integer> cache = new HashMap<>();
	
	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		if (cache.containsKey(root))
			return cache.get(root);
		
		int val = root.val;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null)
			val += rob(left.left) + rob(left.right);
		if (right != null)
			val += rob(right.left) + rob(right.right);
		
		val = Math.max(val, rob(left) + rob(right));
		cache.put(root, val);
		
		return val;
	}
}
