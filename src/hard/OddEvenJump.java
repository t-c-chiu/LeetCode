package hard;

import java.util.TreeMap;

public class OddEvenJump {
	
	public static void main(String[] args) {
		int res = oddEvenJumps(new int[]{2, 3, 1, 1, 4});
		System.out.println(res);
	}
	
	public static int oddEvenJumps(int[] arr) {
		int res = 1, n = arr.length;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		boolean[][] dp = new boolean[n][2];
		dp[n - 1][0] = dp[n - 1][1] = true;
		map.put(arr[n - 1], n - 1);
		for (int i = n - 2; i >= 0; i--) {
			int num = arr[i];
			if (map.ceilingEntry(num) != null) {
				int j = map.ceilingEntry(num).getValue();
				dp[i][0] = dp[j][1];
				if (dp[i][0]) {
					res++;
				}
			}
			if (map.floorEntry(num) != null) {
				int j = map.floorEntry(num).getValue();
				dp[i][1] = dp[j][0];
			}
			map.put(num, i);
		}
		return res;
	}
}
