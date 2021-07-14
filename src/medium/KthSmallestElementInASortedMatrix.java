package medium;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	
	public static void main(String[] args) {
		int res = kthSmallest(new int[][]{
				{1, 5, 9},
				{10, 11, 13},
				{12, 13, 15},
		}, 8);
		System.out.println(res);
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; i++) {
			queue.add(new Node(i, 0, matrix[i][0]));
		}
		Node node = null;
		while (k > 0) {
			node = queue.poll();
			k--;
			if (node.y < matrix[0].length - 1) {
				queue.offer(new Node(node.x, node.y + 1, matrix[node.x][node.y + 1]));
			}
		}
		return node.val;
	}
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int val;
		
		public Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
		@Override
		public int compareTo(Node o) {
			return val - o.val;
		}
	}
}
