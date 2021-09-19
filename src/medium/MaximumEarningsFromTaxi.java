package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumEarningsFromTaxi {
	
	public static void main(String[] args) {
		long res = maxTaxiEarnings(20,
				new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}});
		System.out.println(res);
	}
	
	public static long maxTaxiEarnings(int n, int[][] rides) {
		Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));
		long[] dp = new long[n + 1];
		for (int i = 1, j = 0; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			while (j < rides.length && rides[j][0] == i) {
				dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[i] + rides[j][1] - rides[j][0] + rides[j][2]);
				j++;
			}
		}
		return dp[n];
	}
//	public static long maxTaxiEarnings(int n, int[][] rides) {
//		Arrays.sort(rides, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
//		int len = rides.length;
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		long[] dp = new long[len];
//		dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
//		map.put(rides[0][1], 0);
//		for (int i = 1; i < len; i++) {
//			int start = rides[i][0], end = rides[i][1];
//			dp[i] = end - start + rides[i][2];
//			Map.Entry<Integer, Integer> entry = map.floorEntry(start);
//			if (entry != null) {
//				dp[i] += dp[entry.getValue()];
//			}
//			map.put(end, i);
//			dp[i] = Math.max(dp[i], dp[i - 1]);
//		}
//		return dp[len - 1];
//	}
}
