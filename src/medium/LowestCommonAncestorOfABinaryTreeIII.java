package medium;

public class LowestCommonAncestorOfABinaryTreeIII {
	
	public static void main(String[] args) {
	}
	
	public static Node lowestCommonAncestor(Node p, Node q) {
		int pDepth = getDepth(p), qDepth = getDepth(q);
		while (pDepth > qDepth) {
			p = p.parent;
			pDepth--;
		}
		while (pDepth < qDepth) {
			q = q.parent;
			qDepth--;
		}
		while (p != q) {
			p = p.parent;
			q = q.parent;
		}
		return p;
	}
	
	private static int getDepth(Node node) {
		int depth = 0;
		while (node != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}
//	public static Node lowestCommonAncestor(Node p, Node q) {
//		Set<Node> parents = new HashSet<>();
//		while (p != null) {
//			parents.add(p);
//			p = p.parent;
//		}
//		while (q != null) {
//			if (parents.contains(q)) {
//				return q;
//			}
//			q = q.parent;
//		}
//		return null;
//	}
	
	
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	}
}
