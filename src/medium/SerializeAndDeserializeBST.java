package medium;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
	
	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();
		String tree = ser.serialize(TreeNode.generateRoot(new Integer[]{5, 2, 8, 1, null, null, 9}));
		TreeNode ans = deser.deserialize(tree);
		System.out.println(ans);
	}
	
	
	public static class Codec {
		
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder builder = new StringBuilder();
			serialize(root, builder);
			return builder.toString();
		}
		
		private void serialize(TreeNode node, StringBuilder builder) {
			if (node == null) {
				return;
			}
			builder.append(node.val).append(",");
			serialize(node.left, builder);
			serialize(node.right, builder);
		}
		
		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty()) {
				return null;
			}
			Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
			return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		private TreeNode deserialize(Queue<String> queue, int lower, int upper) {
			if (queue.isEmpty()) {
				return null;
			}
			String peek = queue.peek();
			int val = Integer.parseInt(peek);
			if (val < lower || val > upper) {
				return null;
			}
			queue.poll();
			TreeNode node = new TreeNode(val);
			node.left = deserialize(queue, lower, val);
			node.right = deserialize(queue, val, upper);
			return node;
		}
	}
}
