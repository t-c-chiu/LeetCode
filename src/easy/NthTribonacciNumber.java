package easy;

public class NthTribonacciNumber {
	
	public static void main(String[] args) {
		int res = tribonacci(25);
		System.out.println(res);
	}
	
	public static int tribonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int prevprev = 0, prev = 1, cur = 1;
		while (n > 2) {
			int next = prevprev + prev + cur;
			prevprev = prev;
			prev = cur;
			cur = next;
			n--;
		}
		return cur;
	}
}
