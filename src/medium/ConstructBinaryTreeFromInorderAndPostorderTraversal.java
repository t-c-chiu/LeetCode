package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	public static void main(String[] args) {
		TreeNode res = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
		System.out.println(res);
	}
	
	static int cur;
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		cur = postorder.length - 1;
		return buildTree(0, inorder.length - 1, postorder, map);
	}
	
	private static TreeNode buildTree(int start, int end, int[] postorder, Map<Integer, Integer> map) {
		if (start > end) {
			return null;
		}
		
		int val = postorder[cur--];
		TreeNode root = new TreeNode(val);
		root.right = buildTree(map.get(val) + 1, end, postorder, map);
		root.left = buildTree(start, map.get(val) - 1, postorder, map);
		return root;
	}
}
