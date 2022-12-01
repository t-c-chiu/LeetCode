package hard;

public class StudentAttendanceRecordII {
	
	public static void main(String[] args) {
		int res = checkRecord(10101);
		System.out.println(res);
	}
	
	public static int checkRecord(int n) {
		int mod = (int) (1e9 + 7);
		long[] P = new long[n + 1], L = new long[n + 1];
		P[0] = P[1] = L[1] = 1;
		for (int i = 2; i <= n; i++) {
			P[i] = (P[i - 1] + L[i - 1]) % mod;
			L[i] = (P[i - 1] + P[i - 2]) % mod;
		}
		long res = (P[n] + L[n]) % mod;
		for (int i = 0; i < n; i++) {
			long count = (P[i] + L[i]) % mod * (P[n - i - 1] + L[n - i - 1]) % mod;
			res = (res + count) % mod;
		}
		return (int) res;
	}
	
}
