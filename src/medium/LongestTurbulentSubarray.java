package medium;

public class LongestTurbulentSubarray {
	
	public static void main(String[] args) {
		int res = maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
		System.out.println(res);
	}
	
	public static int maxTurbulenceSize(int[] arr) {
		int res = 1, inc = 1, dec = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				inc = dec + 1;
				dec = 1;
			} else if (arr[i] < arr[i - 1]) {
				dec = inc + 1;
				inc = 1;
			} else {
				inc = 1;
				dec = 1;
			}
			res = Math.max(res, Math.max(inc, dec));
		}
		return res;
	}
//	public static int maxTurbulenceSize(int[] arr) {
//		int res = 1, n = arr.length;
//		int[][] dp = new int[n][2];
//		dp[0][0] = dp[0][1] = 1;
//		for (int i = 1; i < n; i++) {
//			dp[i][0] = dp[i][1] = 1;
//			if (arr[i] > arr[i - 1]) {
//				dp[i][0] += dp[i - 1][1];
//			} else if (arr[i] < arr[i - 1]) {
//				dp[i][1] += dp[i - 1][0];
//			}
//			res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
//		}
//		return res;
//	}
}
