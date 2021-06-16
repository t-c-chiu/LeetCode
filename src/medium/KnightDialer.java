package medium;

public class KnightDialer {
	
	public static void main(String[] args) {
		int res = knightDialer(3131);
		System.out.println(res);
	}
	
	static final int MOD = (int) (Math.pow(10, 9) + 7);
	
	public static int knightDialer(int N) {
		int[][] paths = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
		int[][] memo = new int[N + 1][10];
		int res = 0;
		for (int i = 0; i < 10; i++) {
			res = (res + jump(i, N, paths, memo)) % MOD;
		}
		return res;
	}
	
	private static int jump(int i, int n, int[][] paths, int[][] memo) {
		if (n == 1) {
			return 1;
		}
		if (memo[n][i] > 0) {
			return memo[n][i];
		}
		int res = 0;
		for (int next : paths[i]) {
			res = (res + jump(next, n - 1, paths, memo)) % MOD;
		}
		memo[n][i] = res;
		return res;
	}
}
