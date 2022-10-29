package easy;

public class FibonacciNumber {
	
	public static void main(String[] args) {
		int res = fib(5);
		System.out.println(res);
	}
	
	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int prev = 0, cur = 1;
		while (n > 1) {
			int temp = cur;
			cur += prev;
			prev = temp;
			n--;
		}
		return cur;
	}
}
