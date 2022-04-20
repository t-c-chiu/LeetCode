package medium;

public class InorderSuccessorInBSTII {
	
	public static void main(String[] args) {
	
	}
	
	public static Node inorderSuccessor(Node node) {
		if (node.right == null) {
			while (node.parent != null && node.parent.right == node) {
				node = node.parent;
			}
			return node.parent;
		} else {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
	}
	
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	}
}
