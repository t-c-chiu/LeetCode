package medium;

public class populatingNextRightPointersInEachNode {
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node res = connect(root);
		System.out.println(res);
	}
	
	public static Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Node cur = root;
		while (cur != null) {
			Node first = cur;
			while (cur != null) {
				if (cur.left != null) {
					cur.left.next = cur.right;
					if (cur.next != null) {
						cur.right.next = cur.next.left;
					}
				}
				cur = cur.next;
			}
			cur = first.left;
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
