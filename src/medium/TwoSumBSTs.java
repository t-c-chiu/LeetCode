package medium;

import util.TreeNode;

public class TwoSumBSTs {
	
	public static void main(String[] args) {
		TreeNode root1 = TreeNode.generateRoot(new Integer[]{2, 1, 4});
		TreeNode root2 = TreeNode.generateRoot(new Integer[]{1, 0, 3});
		boolean res = twoSumBSTs(root1, root2, 5);
		System.out.println(res);
	}
	
	public static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		if (root1 == null || root2 == null) {
			return false;
		}
		
		if (search(root2, target - root1.val)) {
			return true;
		}
		return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
	}
	
	private static boolean search(TreeNode node, int target) {
		if (node == null) {
			return false;
		}
		
		if (node.val == target) {
			return true;
		} else if (node.val < target) {
			return search(node.right, target);
		} else {
			return search(node.left, target);
		}
	}


//	public static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
//		Set<Integer> set1 = new HashSet<>();
//		inOrder(root1, set1);
//		Set<Integer> set2 = new HashSet<>();
//		inOrder(root2, set2);
//		for (Integer i : set1) {
//			if (set2.contains(target - i)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private static void inOrder(TreeNode node, Set<Integer> set) {
//		if (node == null) {
//			return;
//		}
//		inOrder(node.left, set);
//		set.add(node.val);
//		inOrder(node.right, set);
//	}
}
