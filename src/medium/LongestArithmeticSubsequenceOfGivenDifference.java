package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
	
	public static void main(String[] args) {
		int res = longestSubsequence(new int[]{1,3,5,7},1);
		System.out.println(res);
	}
	
	public static int longestSubsequence(int[] arr, int difference) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i : arr) {
			map.put(i, map.getOrDefault(i - difference, 0) + 1);
			res = Math.max(res, map.get(i));
		}
		return res;
	}
}
