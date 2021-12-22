package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
	
	public static void main(String[] args) {
		int res = sumNumbers(TreeNode.generateRoot(new Integer[]{4, 9, 0, 5, 1}));
		System.out.println(res);
	}
	
	public static int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}
	
	private static int dfs(TreeNode node, int val) {
		if (node == null) {
			return 0;
		}
		val = val * 10 + node.val;
		if (isLeaf(node)) {
			return val;
		}
		return dfs(node.left, val) + dfs(node.right, val);
	}
	
	//	static int sum = 0;
//
//	public static int sumNumbers(TreeNode root) {
//		dfs(root, 0);
//		return sum;
//	}
//
//	private static void dfs(TreeNode node, int num) {
//		if (node == null) {
//			return;
//		}
//		num *= 10;
//		num += node.val;
//		if (isLeaf(node)) {
//			sum += num;
//			return;
//		}
//		dfs(node.left, num);
//		dfs(node.right, num);
//	}
//
	private static boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}
}
