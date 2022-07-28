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
		
		String splitter = ",";
		String nullChar = "#";
		
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			serialize(root, sb);
			return sb.toString();
		}
		
		private void serialize(TreeNode root, StringBuilder sb) {
			if (root == null) {
				sb.append(nullChar).append(splitter);
			} else {
				sb.append(root.val).append(splitter);
				serialize(root.left, sb);
				serialize(root.right, sb);
			}
		}
		
		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			Queue<String> q = new LinkedList<>();
			for (String v : data.split(splitter)) {
				q.offer(v);
			}
			return deserialize(q);
		}
		
		private TreeNode deserialize(Queue<String> q) {
			String val = q.poll();
			if (nullChar.equals(val)) {
				return null;
			}
			TreeNode node = new TreeNode(Integer.parseInt(val));
			node.left = deserialize(q);
			node.right = deserialize(q);
			return node;
		}
	}
}
