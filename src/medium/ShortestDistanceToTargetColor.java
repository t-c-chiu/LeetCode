package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class ShortestDistanceToTargetColor {
	
	public static void main(String[] args) {
		List<Integer> res = shortestDistanceColor(
				new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3},
				new int[][]{{1, 3}, {2, 2}, {6, 1}});
		System.out.println(res);
	}
	
	public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
		int n = colors.length;
		int[][] dp = new int[n][3];
		for (int[] arr : dp) {
			Arrays.fill(arr, n);
		}
		dp[0][colors[0] - 1] = 0;
		for (int i = 1; i < n; i++) {
			dp[i][colors[i] - 1] = 0;
			for (int k = 0; k < 3; k++) {
				dp[i][k] = Math.min(dp[i][k], dp[i - 1][k] + 1);
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			dp[i][colors[i] - 1] = 0;
			for (int k = 0; k < 3; k++) {
				dp[i][k] = Math.min(dp[i][k], dp[i + 1][k] + 1);
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int[] query : queries) {
			int i = dp[query[0]][query[1] - 1];
			res.add(i == n ? -1 : i);
		}
		return res;
	}

//	public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
//		List<Integer> res = new ArrayList<>();
//		TreeSet<Integer>[] sets = new TreeSet[3];
//		for (int i = 0; i < sets.length; i++) {
//			sets[i] = new TreeSet<>();
//		}
//		for (int i = 0; i < colors.length; i++) {
//			int j = colors[i] - 1;
//			sets[j].add(i);
//		}
//		for (int[] query : queries) {
//			TreeSet<Integer> set = sets[query[1] - 1];
//			int i = query[0];
//			Integer lower = set.floor(i);
//			Integer higher = set.ceiling(i);
//			if (lower == null && higher == null) {
//				res.add(-1);
//			} else if (lower == null) {
//				res.add(higher - i);
//			} else if (higher == null) {
//				res.add(i - lower);
//			} else {
//				res.add(Math.min(higher - i, i - lower));
//			}
//		}
//		return res;
//	}
}
