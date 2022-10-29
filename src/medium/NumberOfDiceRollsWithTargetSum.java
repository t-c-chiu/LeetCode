package medium;

public class NumberOfDiceRollsWithTargetSum {
	
	public static void main(String[] args) {
		int res = numRollsToTarget(2, 6, 7);
		System.out.println(res);
	}
	
	public static int numRollsToTarget(int n, int k, int target) {
		int MOD = (int) (1e9 + 7);
		int[][] dp = new int[n + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				for (int f = 1; f <= k; f++) {
					if (j >= f) {
						dp[i][j] = (dp[i][j] + dp[i - 1][j - f]) % MOD;
					}
				}
			}
		}
		return dp[n][target];
	}
//	static Map<String, Integer> map = new HashMap<>();
//
//	public static int numRollsToTarget(int n, int k, int target) {
//		int MOD = (int) (1e9 + 7);
//		if (n == 0 && target == 0) {
//			return 1;
//		}
//		if (n == 0 || target == 0) {
//			return 0;
//		}
//		String key = n + " " + target;
//		if (map.containsKey(key)) {
//			return map.get(key);
//		}
//		int res = 0;
//		for (int i = 1; i <= k; i++) {
//			if (target >= i) {
//				res = (res + numRollsToTarget(n - 1, k, target - i)) % MOD;
//			}
//		}
//		map.put(key, res);
//		return res;
//	}
}
