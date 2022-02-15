package medium;

public class TheKthFactorOfN {
	
	public static void main(String[] args) {
		int res = kthFactor(12, 5);
		System.out.println(res);
	}
	
	public static int kthFactor(int n, int k) {
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0 && --k == 0) {
				return i;
			}
		}
		for (int i = (int) Math.sqrt(n); i >= 1; i--) {
			if (n % (n / i) == 0 && --k == 0) {
				return n / i;
			}
		}
		return -1;
	}
	
//	public static int kthFactor(int n, int k) {
//		for (int i = 1; i <= n; i++) {
//			if (n % i == 0) {
//				k--;
//			}
//			if (k == 0) {
//				return i;
//			}
//		}
//		return -1;
//	}
}
