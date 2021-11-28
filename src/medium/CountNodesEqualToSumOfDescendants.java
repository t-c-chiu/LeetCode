package medium;

import util.TreeNode;

public class CountNodesEqualToSumOfDescendants {
	
	public static void main(String[] args) {
		int res = equalToDescendants(TreeNode.generateRoot(new Integer[]{2,3,null,2,null}));
		System.out.println(res);
	}
	
	static int res = 0;
	
	public static int equalToDescendants(TreeNode root) {
		dfs(root);
		return res;
	}
	
	private static int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int sum = dfs(node.left) + dfs(node.right);
		if (sum == node.val) {
			res++;
		}
		return sum + node.val;
	}
}
