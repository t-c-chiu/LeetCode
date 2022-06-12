package hard;

public class TotalAppealOfAString {
	
	public static void main(String[] args) {
		long res = appealSum("abbca");
		System.out.println(res);
	}
	
	public static long appealSum(String s) {
		int n = s.length();
		long res = 0;
		long[] dp = new long[n + 1];
		int[] prev = new int[26];
		for (int i = 1; i <= n; i++) {
			int j = s.charAt(i - 1) - 'a';
			dp[i] = dp[i - 1] + i - prev[j];
			res += dp[i];
			prev[j] = i;
		}
		return res;
	}
//	public static long appealSum(String s) {
//		long res = 0, cur = 0;
//		int[] prev = new int[26];
//		for (int i = 0; i < s.length(); i++) {
//			int j = s.charAt(i) - 'a';
//			cur += i + 1 - prev[j];
//			res += cur;
//			prev[j] = i + 1;
//		}
//		return res;
//	}
	
}
