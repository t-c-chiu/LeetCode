package medium;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	
	public static void main(String[] args) {
	}
	
	Node first, last;
	
	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		helper(root);
		first.left = last;
		last.right = first;
		return first;
	}
	
	private void helper(Node node) {
		if (node == null) {
			return;
		}
		helper(node.left);
		if (first == null) {
			first = node;
		}
		if (last != null) {
			last.right = node;
			node.left = last;
		}
		last = node;
		helper(node.right);
	}
	
	class Node {
		public int val;
		public Node left;
		public Node right;
		
		public Node() {
		}
		
		public Node(int _val) {
			val = _val;
		}
		
		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}
	
}
