package medium;

import java.util.*;

public class MinimumAbsoluteDifferenceQueries {
	
	public static void main(String[] args) {
		int[] res = minDifference(new int[]{4, 5, 2, 2, 7, 10}, new int[][]{{2, 3}, {0, 2}, {0, 5}, {3, 5}});
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
	}
	
	public static int[] minDifference(int[] nums, int[][] queries) {
		int n = nums.length, q = queries.length;
		int[] res = new int[q];
		int[][] count = new int[n + 1][100];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 100; j++) {
				count[i + 1][j] = count[i][j];
			}
			count[i + 1][nums[i] - 1]++;
		}
		for (int i = 0; i < q; i++) {
			int low = queries[i][0];
			int high = queries[i][1] + 1;
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < 100; j++) {
				if (count[high][j] - count[low][j] > 0) {
					list.add(j);
				}
			}
			if (list.size() == 1) {
				res[i] = -1;
				continue;
			}
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < list.size() - 1; j++) {
				min = Math.min(min, list.get(j + 1) - list.get(j));
			}
			res[i] = min;
		}
		return res;
	}
}
