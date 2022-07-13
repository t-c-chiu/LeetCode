package medium;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CompleteBinaryTreeInserter {
	
	public static void main(String[] args) {
		CBTInserter cBTInserter = new CBTInserter(TreeNode.generateRoot(new Integer[]{1}));
		int parent = cBTInserter.insert(2);// return 1
		System.out.println(parent);
		parent = cBTInserter.insert(3);  // return 2
		System.out.println(parent);
		parent = cBTInserter.insert(4);  // return 2
		System.out.println(parent);
		TreeNode root = cBTInserter.get_root();// return [1, 2, 3, 4]
		System.out.println(root);
	}
	
	static class CBTInserter {
		TreeNode root;
		Deque<TreeNode> queue;
		
		public CBTInserter(TreeNode root) {
			this.root = root;
			queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty() && queue.peek().left != null && queue.peek().right != null) {
				TreeNode poll = queue.poll();
				queue.offer(poll.left);
				queue.offer(poll.right);
			}
		}
		
		public int insert(int val) {
			TreeNode newNode = new TreeNode(val);
			TreeNode peek = queue.peek();
			if (peek.left == null) {
				peek.left = newNode;
			} else {
				peek.right = newNode;
				queue.offer(peek.left);
				queue.offer(peek.right);
				queue.poll();
			}
			return peek.val;
		}
		
		public TreeNode get_root() {
			return root;
		}
	}
}
