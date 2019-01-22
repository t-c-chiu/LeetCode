package medium;

public class TwoKeysKeyboard {
	public static void main(String[] args) {
		TwoKeysKeyboard twoKeysKeyboard = new TwoKeysKeyboard();
		for (int i = 1; i < 10; i++)
			System.out.println(twoKeysKeyboard.minSteps(i));
	}

	// 2 -> C1 P2
	// 3 -> C1 P2 P3
	// 4 -> C1 P2 C2 P4
	// 5 -> C1 P2 P3 P4 P5
	// 6 -> C1 P2 P3 C3 P6
	// 7 -> C1 P2 P3 P4 P5 P6 P7
	// 8 -> C1 P2 C2 P4 C4 P8
	// 9 -> C1 P2 P3 C3 P6 P9
	// 0 2 3 4 5 5 7 6 6
	public int minSteps(int n) {
		if (n == 1)
			return 0;
		for (int i = n - 1; i > 0; i--) {
			if (n % i == 0) {
				return n / i + minSteps(i);
			}
		}
		return -1;
	}
}
