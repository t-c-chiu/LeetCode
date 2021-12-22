package medium;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeIII {
	
	public static void main(String[] args) {
	}
	
	public static Node lowestCommonAncestor(Node p, Node q) {
		Node a = p, b = q;
		while (a != b) {
			a = a.parent != null ? a.parent : q;
			b = b.parent != null ? b.parent : p;
		}
		return a;
	}
//	public static Node lowestCommonAncestor(Node p, Node q) {
//		Set<Node> pParents = new HashSet<>();
//		addParents(pParents, p);
//		return search(pParents, q);
//	}
//
//	private static void addParents(Set<Node> pParents, Node p) {
//		while (p != null) {
//			pParents.add(p);
//			p = p.parent;
//		}
//	}
//
//	private static Node search(Set<Node> pParents, Node q) {
//		while (q != null) {
//			if (pParents.contains(q)) {
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
