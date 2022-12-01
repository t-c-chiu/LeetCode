package medium;

public class MinimumAdditionToMakeIntegerBeautiful {
	
	public static void main(String[] args) {
		long res = makeIntegerBeautiful(16, 6);
		System.out.println(res);
	}
	
	public static long makeIntegerBeautiful(long n, int target) {
		long digitSum = digitSum(n), res = 0;
		while (digitSum > target) {
			long temp = n;
			int pow = 1;
			while (temp % 10 == 0) {
				temp /= 10;
				pow *= 10;
			}
			long add = 10L * pow - (temp % 10) * pow;
			n += add;
			res += add;
			digitSum = digitSum(n);
		}
		return res;
	}
	
	private static long digitSum(long n) {
		long sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
