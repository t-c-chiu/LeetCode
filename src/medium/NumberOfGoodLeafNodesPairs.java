package medium;

import util.TreeNode;

public class NumberOfGoodLeafNodesPairs {
	
	public static void main(String[] args) {
		int res = countPairs(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5, 6, 7}), 3);
		System.out.println(res);
	}
	
	static int res;
	
	public static int countPairs(TreeNode root, int distance) {
		dfs(root, distance);
		return res;
	}
	
	private static int[] dfs(TreeNode node, int distance) {
		int[] dis = new int[distance + 1];
		if (node == null) {
			return dis;
		}
		if (node.left == null && node.right == null) {
			dis[1]++;
			return dis;
		}
		int[] left = dfs(node.left, distance);
		int[] right = dfs(node.right, distance);
		for (int i = 1; i <= distance; i++) {
			for (int j = 1; j <= distance; j++) {
				if (i + j <= distance) {
					res += left[i] * right[j];
				}
			}
		}
		for (int i = 1; i <= distance; i++) {
			dis[i] += left[i - 1];
			dis[i] += right[i - 1];
		}
		return dis;
	}
}
