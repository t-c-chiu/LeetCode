package medium;

public class PowXN {
	
	public static void main(String[] args) {
		double res = myPow(2, -10);
		System.out.println(res);
	}
	
	public static double myPow(double x, int n) {
		return myPow(x, (long) n);
	}
	
	public static double myPow(double x, long n) {
		if (n < 0) {
			return 1 / myPow(x, -n);
		}
		if (n == 0) {
			return 1;
		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}
