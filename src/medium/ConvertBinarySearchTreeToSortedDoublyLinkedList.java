package medium;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	
	public static void main(String[] args) {
	}
	
	Node first;
	Node last;
	
	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		
		dfs(root);
		first.left = last;
		last.right = first;
		return first;
	}
	
	private void dfs(Node node) {
		if (node == null) {
			return;
		}
		
		dfs(node.left);
		if (first == null) {
			first = last = node;
		} else {
			last.right = node;
			node.left = last;
			last = node;
		}
		dfs(node.right);
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
	
	;
}
