package easy;

import util.TreeNode;

public class ConvertBSTToGreaterTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		TreeNode res = new ConvertBSTToGreaterTree().convertBST(root);
		System.out.println(res.val);
		System.out.println(res.left.val);
		System.out.println(res.right.val);
	}
	
	private int sum = 0;
	
	public TreeNode convertBST(TreeNode root) {
		convert(root);
		return root;
	}
	
	private void convert(TreeNode root) {
		if (root == null)
			return;
		
		convert(root.right);
		int value = root.val;
		root.val += sum;
		sum += value;
		convert(root.left);
	}
	
}
