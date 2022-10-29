package medium;

public class ReverseInteger {
	
	public static void main(String[] args) {
		int res = reverse(1534236469);
		System.out.println(res);
		res = reverse(-123);
		System.out.println(res);
		res = reverse(120);
		System.out.println(res);
	}
	
	public static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int prev = res;
			res = res * 10 + x % 10;
			if (res / 10 != prev) {
				return 0;
			}
			x /= 10;
		}
		return res;
	}
}
