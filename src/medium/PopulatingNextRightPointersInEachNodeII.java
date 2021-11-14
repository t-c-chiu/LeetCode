package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(7);
		Node res = connect(root);
		System.out.println(res);
	}
	
	public static Node connect(Node root) {
		if (root == null) {
			return null;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			Node prev = null;
			for (int i = 0; i < size; i++) {
				Node poll = queue.poll();
				if (prev != null) {
					prev.next = poll;
				}
				if (poll.left != null) {
					queue.offer(poll.left);
				}
				if (poll.right != null) {
					queue.offer(poll.right);
				}
				prev = poll;
			}
		}
		return root;
	}
	
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;
		
		public Node() {
		}
		
		public Node(int _val) {
			val = _val;
		}
		
		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					", left=" + left +
					", right=" + right +
					", next=" + next +
					'}';
		}
	}
}
