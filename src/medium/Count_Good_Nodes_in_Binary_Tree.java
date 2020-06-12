package medium;

import util.TreeNode;

public class Count_Good_Nodes_in_Binary_Tree {
	
	public static void main(String[] args) {
		Count_Good_Nodes_in_Binary_Tree test = new Count_Good_Nodes_in_Binary_Tree();
		int res = test.goodNodes(TreeNode.generateRoot(new Integer[]{3, 1, 4, 3, null, 1, 5}));
		System.out.println(res);
	}
	
	
	public int goodNodes(TreeNode root) {
		return countGoodNodes(root, root.val);
	}
	
	private int countGoodNodes(TreeNode node, int max) {
		if (node == null) {
			return 0;
		}
		
		int count = 0;
		if (node.val >= max) {
			max = node.val;
			count = 1;
		}
		return count + countGoodNodes(node.left, max) + countGoodNodes(node.right, max);
	}
}
