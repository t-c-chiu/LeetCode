package hard;

public class CountVowelsPermutation {
	
	public static void main(String[] args) {
		int res = countVowelPermutation(5);
		System.out.println(res);
	}
	
	public static int countVowelPermutation(int n) {
		int mod = (int) (1e9 + 7);
		long a = 1, e = 1, i = 1, o = 1, u = 1;
		for (int j = 1; j < n; j++) {
			long nextA = (e + i + u) % mod;
			long nextE = (a + i) % mod;
			long nextI = (e + o) % mod;
			long nextO = i % mod;
			long nextU = (i + o) % mod;
			a = nextA;
			e = nextE;
			i = nextI;
			o = nextO;
			u = nextU;
		}
		return (int) ((a + e + i + o + u) % mod);
	}
	
//	public static int countVowelPermutation(int n) {
//		int mod = (int) (1e9 + 7), res = 0;
//		long[][] dp = new long[n][5];
//		for (int i = 0; i < 5; i++) {
//			dp[0][i] = 1;
//		}
//		for (int i = 1; i < n; i++) {
//			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
//			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
//			dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
//			dp[i][3] = dp[i - 1][2] % mod;
//			dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
//		}
//		for (int i = 0; i < 5; i++) {
//			res = (int) ((res + dp[n - 1][i]) % mod);
//		}
//		return res;
//	}
}
