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
		while (qDepth > pDepth) {
			q = q.parent;
			qDepth--;
		}
		while (p != q) {
			p = p.parent;
			q = q.parent;
		}
		return p;
	}
	
	private static int getDepth(Node n) {
		int depth = 0;
		while (n.parent != null) {
			n = n.parent;
			depth++;
		}
		return depth;
	}

//	public static Node lowestCommonAncestor(Node p, Node q) {
//		Node a = p, b = q;
//		while (a != b) {
//			a = a.parent == null ? q : a.parent;
//			b = b.parent == null ? p : b.parent;
//		}
//		return a;
//	}
	
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	}
}
