package medium;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {
	
	public static void main(String[] args) {
		long res = maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}});
		System.out.println(res);
	}
	
	public static long maximumImportance(int n, int[][] roads) {
		long res = 0;
		int[] count = new int[n];
		for (int[] road : roads) {
			count[road[0]]++;
			count[road[1]]++;
		}
		Arrays.sort(count);
		for (int i = count.length - 1; i >= 0; i--) {
			res += (long) count[i] * n--;
		}
		return res;
	}
}
