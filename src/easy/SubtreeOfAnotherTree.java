package easy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {
	
	public static void main(String[] args) {
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		System.out.println(new SubtreeOfAnotherTree().isSubtree(s, t));
	}
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return false;
		if (s == null || t == null)
			return false;
		List<TreeNode> sameValNodes = new ArrayList<>();
		findSameValNode(s, t.val, sameValNodes);
		for (TreeNode node : sameValNodes) {
			if (isSameTree(node, t))
				return true;
		}
		return false;
	}
	
	private void findSameValNode(TreeNode s, int subVal, List<TreeNode> sameValNodes) {
		if (s == null)
			return;
		if (s.val == subVal)
			sameValNodes.add(s);
		findSameValNode(s.left, subVal, sameValNodes);
		findSameValNode(s.right, subVal, sameValNodes);
	}
	
	private boolean isSameTree(TreeNode node, TreeNode t) {
		if (node == null && t == null)
			return true;
		if (node == null || t == null)
			return false;
		if (node.val != t.val)
			return false;
		
		return isSameTree(node.left, t.left) && isSameTree(node.right, t.right);
	}
}
