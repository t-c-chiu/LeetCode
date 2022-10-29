package easy;

public class HappyNumber {
	
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
	
	public static boolean isHappy(int n) {
		int slow = n, fast = n;
		do {
			slow = next(slow);
			fast = next(next(fast));
		} while (slow != fast);
		return slow == 1;
	}
	
	private static int next(int n) {
		int res = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			res += lastDigit * lastDigit;
			n /= 10;
		}
		return res;
	}
}
