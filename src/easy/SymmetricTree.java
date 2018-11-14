package easy;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(new SymmetricTree().isSymmetric(root));
	}

	private List<Integer> leftVals = new ArrayList<>();
	private List<Integer> rightVals = new ArrayList<>();

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		storeLeft(root.left);
		storeRight(root.right);
		if (leftVals.size() != rightVals.size())
			return false;
		for (int i = 0; i < leftVals.size(); i++) {
			if (leftVals.get(i) != rightVals.get(i))
				return false;
		}
		return true;
	}

	private void storeLeft(TreeNode left) {
		if (left == null) {
			leftVals.add(null);
			return;
		}
		storeLeft(left.left);
		storeLeft(left.right);
		leftVals.add(left.val);
	}

	private void storeRight(TreeNode right) {
		if (right == null) {
			rightVals.add(null);
			return;
		}
		storeRight(right.right);
		storeRight(right.left);
		rightVals.add(right.val);
	}

	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;

		return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}
}
