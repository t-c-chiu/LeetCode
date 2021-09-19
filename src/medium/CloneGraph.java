package medium;

import java.util.*;

public class CloneGraph {
	
	public static void main(String[] args) {
		Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4);
		n1.neighbors.addAll(Arrays.asList(n2, n4));
		n2.neighbors.addAll(Arrays.asList(n1, n3));
		n3.neighbors.addAll(Arrays.asList(n2, n4));
		n4.neighbors.addAll(Arrays.asList(n1, n3));
		Node res = cloneGraph(n1);
		System.out.println(res);
	}
	
	public static Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		return cloneGraph(new HashMap<>(), node);
	}
	
	private static Node cloneGraph(Map<Integer, Node> map, Node node) {
		int val = node.val;
		if (map.containsKey(val)) {
			return map.get(val);
		}
		
		Node newNode = new Node(val);
		map.put(val, newNode);
		for (Node neighbor : node.neighbors) {
			newNode.neighbors.add(cloneGraph(map, neighbor));
		}
		return newNode;
	}
	
	static class Node {
		public int val;
		public List<Node> neighbors;
		
		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}
		
		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}
		
		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
