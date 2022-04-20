package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {
	
	public static void main(String[] args) {
		TreeNode res = createBinaryTree(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
		System.out.println(res);
	}
	
	public static TreeNode createBinaryTree(int[][] descriptions) {
		Map<Integer, TreeNode> map = new HashMap<>();
		for (int[] description : descriptions) {
			int parent = description[0];
			int child = description[1];
			boolean isLeft = description[2] == 1;
			map.putIfAbsent(parent, new TreeNode(parent));
			map.putIfAbsent(child, new TreeNode(child));
			if (isLeft) {
				map.get(parent).left = map.get(child);
			} else {
				map.get(parent).right = map.get(child);
			}
		}
		for (int[] description : descriptions) {
			map.remove(description[1]);
		}
		for (TreeNode root : map.values()) {
			return root;
		}
		return null;
	}
}
