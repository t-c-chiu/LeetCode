package medium;

import util.TreeNode;

public class DeepestLeavesSum {
	
	public static void main(String[] args) {
		int res = deepestLeavesSum(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8}));
		System.out.println(res);
	}
	
	static int res = 0;
	static int maxLevel = 0;
	
	public static int deepestLeavesSum(TreeNode root) {
		dfs(root, 0);
		return res;
	}
	
	private static void dfs(TreeNode node, int level) {
		if (node == null) {
			return;
		}
		if (level > maxLevel) {
			res = 0;
			maxLevel = level;
		}
		if (level == maxLevel) {
			res += node.val;
		}
		dfs(node.left, level + 1);
		dfs(node.right, level + 1);
	}

//	public static int deepestLeavesSum(TreeNode root) {
//		int res = 0;
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			res = 0;
//			for (int i = queue.size(); i > 0; i--) {
//				TreeNode poll = queue.poll();
//				res += poll.val;
//				if (poll.left != null) {
//					queue.offer(poll.left);
//				}
//				if (poll.right != null) {
//					queue.offer(poll.right);
//				}
//			}
//		}
//		return res;
//	}
}
