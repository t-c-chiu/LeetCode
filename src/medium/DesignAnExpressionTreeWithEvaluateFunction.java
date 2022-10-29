package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DesignAnExpressionTreeWithEvaluateFunction {
	
	public static void main(String[] args) {
		TreeBuilder builder = new TreeBuilder();
		Node root = builder.buildTree(new String[]{"4", "5", "2", "7", "+", "-", "*"});
		int res = root.evaluate();
		System.out.println(res);
	}
	
	abstract static class Node {
		String val;
		Node left;
		Node right;
		
		public Node(String val) {
			this.val = val;
		}
		
		public abstract int evaluate();
		// define your fields here
	}
	
	static class NumNode extends Node {
		
		public NumNode(String val) {
			super(val);
		}
		
		@Override
		public int evaluate() {
			return Integer.parseInt(val);
		}
	}
	
	static class OpNode extends Node {
		
		public OpNode(String val) {
			super(val);
		}
		
		@Override
		public int evaluate() {
			switch (val) {
				case "+":
					return left.evaluate() + right.evaluate();
				case "-":
					return left.evaluate() - right.evaluate();
				case "*":
					return left.evaluate() * right.evaluate();
				case "/":
					return left.evaluate() / right.evaluate();
			}
			return -1;
		}
	}
	
	static class TreeBuilder {
		Node buildTree(String[] postfix) {
			Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
			Stack<Node> stack = new Stack<>();
			for (String val : postfix) {
				Node node = null;
				if (ops.contains(val)) {
					node = new OpNode(val);
					node.right = stack.pop();
					node.left = stack.pop();
				} else {
					node = new NumNode(val);
				}
				stack.push(node);
			}
			return stack.pop();
		}
	}
}
