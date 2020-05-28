package medium;

import util.TreeNode;

public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
	
	public static void main(String[] args) {
		Integer[] vals = {7, 4, 3, null, null, 6, 19};
		TreeNode original = TreeNode.generateRoot(vals);
		TreeNode cloned = TreeNode.generateRoot(vals);
		
		Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree test = new Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree();
		TreeNode res = test.getTargetCopy(original, cloned, original.right);
		System.out.println(res);
	}
	
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if (original == null) {
			return null;
		}
		if (original == target) {
			return cloned;
		}
		
		TreeNode node = getTargetCopy(original.left, cloned.left, target);
		return node != null ? node : getTargetCopy(original.right, cloned.right, target);
	}
}
