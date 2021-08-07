package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	
	public static void main(String[] args) {
		List<TreeNode> res = generateTrees(3);
		System.out.println(res);
	}
	
	public static List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
	
	private static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> treeNodes = new ArrayList<>();
		if (start > end) {
			treeNodes.add(null);
			return treeNodes;
		}
		if (start == end) {
			treeNodes.add(new TreeNode(start));
			return treeNodes;
		}
		
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode node = new TreeNode(i);
					node.left = l;
					node.right = r;
					treeNodes.add(node);
				}
			}
		}
		return treeNodes;
	}
}
