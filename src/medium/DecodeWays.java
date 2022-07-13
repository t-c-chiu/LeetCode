package medium;

public class DecodeWays {
	
	public static void main(String[] args) {
		int res = numDecodings("226");
		System.out.println(res);
	}
	
	public static int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length(), prev = 1, cur = 1;
		for (int i = 1; i < n; i++) {
			char prevChar = s.charAt(i - 1);
			char curChar = s.charAt(i);
			int temp = 0;
			if (curChar != '0') {
				temp += cur;
			}
			if (prevChar == '1' || prevChar == '2' && curChar <= '6') {
				temp += prev;
			}
			prev = cur;
			cur = temp;
		}
		return cur;
	}

//	public static int numDecodings(String s) {
//		if (s.charAt(0) == '0') {
//			return 0;
//		}
//		int n = s.length();
//		int[] dp = new int[n + 1];
//		dp[0] = dp[1] = 1;
//		for (int i = 1; i < n; i++) {
//			char prev = s.charAt(i - 1);
//			char cur = s.charAt(i);
//			if (cur != '0') {
//				dp[i + 1] = dp[i];
//			}
//			if (prev == '1' || prev == '2' && cur <= '6') {
//				dp[i + 1] += dp[i - 1];
//			}
//		}
//		return dp[n];
//	}
}
