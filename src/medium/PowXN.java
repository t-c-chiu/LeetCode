package medium;

public class PowXN {
	
	public static void main(String[] args) {
		double res = myPow(2, -10);
		System.out.println(res);
	}
	
	public static double myPow(double x, int n) {
		double res = helper(x, n);
		return n >= 0 ? res : 1 / res;
	}
	
	private static double helper(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return helper(x * x, n / 2);
		} else {
			return x * helper(x * x, n / 2);
		}
	}
}
