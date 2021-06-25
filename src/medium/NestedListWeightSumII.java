package medium;

import java.util.List;

public class NestedListWeightSumII {
	
	public static void main(String[] args) {
	
	}
	
	public static int depthSumInverse(List<NestedInteger> nestedList) {
		int maxDepth = 0;
		for (NestedInteger ni : nestedList) {
			maxDepth = Math.max(maxDepth, getMaxDepth(ni));
		}
		
		int res = 0;
		for (NestedInteger ni : nestedList) {
			res += getWeight(ni, 1, maxDepth);
		}
		return res;
	}
	
	private static int getMaxDepth(NestedInteger ni) {
		if (ni.isInteger()) {
			return 1;
		}
		
		int maxDepth = 0;
		for (NestedInteger next : ni.getList()) {
			maxDepth = Math.max(maxDepth, getMaxDepth(next));
		}
		return maxDepth + 1;
	}
	
	private static int getWeight(NestedInteger ni, int depth, int maxDepth) {
		if (ni.isInteger()) {
			return (maxDepth - depth + 1) * ni.getInteger();
		}
		
		int weight = 0;
		for (NestedInteger next : ni.getList()) {
			weight += getWeight(next, depth + 1, maxDepth);
		}
		return weight;
	}
	
	public interface NestedInteger {
//		// Constructor initializes an empty nested list.
//		NestedInteger();
//
//		// Constructor initializes a single integer.
//		NestedInteger(int value);
		
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		boolean isInteger();
		
		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		Integer getInteger();
		
		// Set this NestedInteger to hold a single integer.
		void setInteger(int value);
		
		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		void add(NestedInteger ni);
		
		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return empty list if this NestedInteger holds a single integer
		List<NestedInteger> getList();
	}
}
