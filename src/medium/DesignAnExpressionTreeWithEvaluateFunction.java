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
	
	static class OptNode extends Node {
		
		public OptNode(String val) {
			super(val);
		}
		
		@Override
		public int evaluate() {
			int leftVal = left.evaluate();
			int rightVal = right.evaluate();
			switch (val) {
				case "+":
					return leftVal + rightVal;
				case "-":
					return leftVal - rightVal;
				case "*":
					return leftVal * rightVal;
				case "/":
					return leftVal / rightVal;
			}
			return Integer.parseInt(val);
		}
	}
	
	static class TreeBuilder {
		Node buildTree(String[] postfix) {
			Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
			Stack<Node> stack = new Stack<>();
			for (String s : postfix) {
				Node newNode;
				if (operators.contains(s)) {
					newNode = new OptNode(s);
					newNode.right = stack.pop();
					newNode.left = stack.pop();
				} else {
					newNode = new NumNode(s);
				}
				stack.push(newNode);
			}
			return stack.pop();
		}
	}
}
