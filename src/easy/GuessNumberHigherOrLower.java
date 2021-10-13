package easy;

public abstract class GuessNumberHigherOrLower {
	
	public static void main(String[] args) {
		guessNumber(10);
	}
	
	static int guess(int num) {
		return -1;
	}
	
	public static int guessNumber(int n) {
		long lo = 1, hi = n;
		int mid = (int) ((lo + hi) / 2);
		while (guess(mid) != 0) {
			if (guess(mid) < 0) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
			mid = (int) ((lo + hi) / 2);
		}
		return mid;
	}
}
