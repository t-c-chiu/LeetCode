package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
	
	public static void main(String[] args) {
		int res = findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}});
		System.out.println(res);
	}
	
	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
		int res = 0, end = Integer.MIN_VALUE;
		for (int[] pair : pairs) {
			if (pair[0] > end) {
				end = pair[1];
				res++;
			}
		}
		return res;
	}
}
