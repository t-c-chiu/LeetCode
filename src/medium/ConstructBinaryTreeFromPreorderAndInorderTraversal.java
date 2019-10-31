package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal test = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		TreeNode node = test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
		TreeNode.printVals(node);
	}
	
	//    3
	//   / \
	//  9  20
	//    /  \
	//   15   7
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			cache.put(inorder[i], i);
		return buildTree(0, 0, inorder.length - 1, preorder, inorder, cache);
	}
	
	// 3 9 20 15 7
	// 9 3 15 20 7
	// inorder[i], 小於i都是他的左節點, 反之亦然
	private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> cache) {
		if (inStart > inEnd)
			return null;
		
		int val = preorder[preStart];
		TreeNode root = new TreeNode(val);
		int inIndex = cache.get(val);
		
		root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder, cache);
		// inIndex - inStart = 左邊節點的數量
		root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, cache);
		return root;
	}
}
