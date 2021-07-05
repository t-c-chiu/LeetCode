package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTreeIterator {
	
	public static void main(String[] args) {
		BSTIterator bSTIterator = new BSTIterator(TreeNode.generateRoot(new Integer[]{7, 3, 15, null, null, 9, 20}));
		bSTIterator.next();    // return 3
		bSTIterator.next();    // return 7
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 9
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 15
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 20
		bSTIterator.hasNext(); // return False
	}
	
	static class BSTIterator {
		
		Iterator<Integer> iterator;
		
		public BSTIterator(TreeNode root) {
			List<Integer> list = new ArrayList<>();
			init(root, list);
			iterator = list.iterator();
		}
		
		private void init(TreeNode node, List<Integer> list) {
			if (node == null) {
				return;
			}
			init(node.left, list);
			list.add(node.val);
			init(node.right, list);
		}
		
		public int next() {
			return iterator.next();
		}
		
		public boolean hasNext() {
			return iterator.hasNext();
		}
	}
}


