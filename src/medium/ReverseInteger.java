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
			int temp = res * 10 + x % 10;
			if (temp / 10 != res) {
				return 0;
			}
			res = temp;
			x /= 10;
		}
		return res;
	}
}
