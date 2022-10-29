package hard;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	
	public static void main(String[] args) {
		Codec codec = new Codec();
		String serialize = codec.serialize(TreeNode.generateRoot(new Integer[]{1, 2, 3, null, null, 4, 5}));
		System.out.println(serialize);
		TreeNode node = codec.deserialize(serialize);
		System.out.println(node);
	}
	
	public static class Codec {
		
		String nullChar = "#";
		String splitter = ",";
		
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			serialize(root, sb);
			return sb.toString();
		}
		
		private void serialize(TreeNode node, StringBuilder sb) {
			if (node == null) {
				sb.append(nullChar).append(splitter);
			} else {
				sb.append(node.val).append(splitter);
				serialize(node.left, sb);
				serialize(node.right, sb);
			}
		}
		
		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			Queue<String> queue = new LinkedList<>();
			for (String s : data.split(splitter)) {
				queue.offer(s);
			}
			return deserialize(queue);
		}
		
		private TreeNode deserialize(Queue<String> queue) {
			String s = queue.poll();
			if (nullChar.equals(s)) {
				return null;
			}
			TreeNode node = new TreeNode(Integer.parseInt(s));
			node.left = deserialize(queue);
			node.right = deserialize(queue);
			return node;
		}
	}
}
