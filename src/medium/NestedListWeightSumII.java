package medium;

import util.NestedInteger;

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
}
