package medium;

public class CountGoodNumbers {
	
	public static void main(String[] args) {
		int res = countGoodNumbers(50);
		System.out.println(res);
	}
	
	private static int MOD = (int) Math.pow(10, 9) + 7;
	
	public static int countGoodNumbers(long n) {
		long evenCount = (n + 1) / 2;
		long oddCount = n - evenCount;
		return (int) ((power(5, evenCount) % MOD) * (power(4, oddCount) % MOD) % MOD);
	}
	
	private static long power(long base, long power) {
		if (power == 0) {
			return 1;
		}
		
		if (power % 2 == 0) {
			return power(base * base % MOD, power / 2) % MOD;
		} else {
			return power(base * base % MOD, power / 2) * base % MOD;
		}
	}
}
