package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node {
	
	public static void main(String[] args) {
		Populating_Next_Right_Pointers_in_Each_Node test = new Populating_Next_Right_Pointers_in_Each_Node();
		Node root = test.new Node(1);
		root.left = test.new Node(2);
		root.right = test.new Node(3);
		root.left.left = test.new Node(4);
		root.left.right = test.new Node(5);
		root.right.left = test.new Node(6);
		root.right.right = test.new Node(7);
		Node res = test.connect(root);
	}
	
	public Node connect(Node root) {
		Node start = root;
		while (start != null) {
			Node cur = start;
			while (cur != null) {
				if (cur.left != null) {
					cur.left.next = cur.right;
				}
				if (cur.right != null && cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			start = start.left;
		}
		return root;
	}
	
	public Node connect2(Node root) {
		if (root == null) {
			return null;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			Node prev = null;
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (prev != null) {
					prev.next = node;
				}
				if (node.left != null && node.right != null) {
					queue.add(node.left);
					queue.add(node.right);
				}
				prev = node;
			}
		}
		return root;
	}
	
	class Node {
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
	}
	
	;
}
