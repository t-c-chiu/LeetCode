package easy;

import util.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfN_AryTree {
	
	public static void main(String[] args) {
		MaximumDepthOfN_AryTree test = new MaximumDepthOfN_AryTree();
		Node root = new Node(1, Arrays.asList(
				new Node(3, Arrays.asList(
						new Node(5, null),
						new Node(6, null))),
				new Node(2, null),
				new Node(4, null)));
		System.out.println(test.maxDepth(root));
	}
	
	
	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		
		int res = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			res++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				for (Node child : node.children) {
					queue.offer(child);
				}
			}
		}
		return res;
	}
}
