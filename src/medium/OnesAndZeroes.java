package medium;

public class OnesAndZeroes {
	
	public static void main(String[] args) {
		int res = findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
		System.out.println(res);
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String str : strs) {
			int zero = 0, one = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '0') {
					zero++;
				} else {
					one++;
				}
			}
			for (int i = m; i >= zero; i--) {
				for (int j = n; j >= one; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
