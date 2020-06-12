package medium;

import util.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Find_Elements_in_a_Contaminated_Binary_Tree {
	
	public static void main(String[] args) {
		Find_Elements_in_a_Contaminated_Binary_Tree test = new Find_Elements_in_a_Contaminated_Binary_Tree();
		FindElements findElements = test.new FindElements(TreeNode.generateRoot(new Integer[]{-1, -1, -1, null, -1}));
		System.out.println(findElements.find(3));
		System.out.println(findElements.find(4));
	}
	
	class FindElements {
		
		private Set<Integer> vals;
		
		public FindElements(TreeNode root) {
			vals = new HashSet<>();
			recoverValue(root, 0);
		}
		
		private void recoverValue(TreeNode node, int val) {
			if (node == null) {
				return;
			}
			vals.add(val);
			recoverValue(node.left, val * 2 + 1);
			recoverValue(node.right, val * 2 + 2);
		}
		
		public boolean find(int target) {
			return vals.contains(target);
		}
	}
}
