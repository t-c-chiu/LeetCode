package medium;

import util.NestedInteger;

import java.util.List;

public class NestedListWeightSum {
	
	public static void main(String[] args) {
	
	}
	
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}
	
	private int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger()) {
				sum += nestedInteger.getInteger() * depth;
			} else {
				sum += depthSum(nestedInteger.getList(), depth + 1);
			}
		}
		return sum;
	}
}
