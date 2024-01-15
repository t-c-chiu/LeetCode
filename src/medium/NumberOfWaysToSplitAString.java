package medium;

public class NumberOfWaysToSplitAString {
	
	public static void main(String[] args) {
		int res = numWays("10101");
		System.out.println(res);
	}
	
	public static int numWays(String s) {
		int n = s.length(), ones = 0, mod = (int) (1e9 + 7);
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1') {
				ones++;
			}
		}
		if (ones % 3 != 0) {
			return 0;
		}
		if (ones == 0) {
			return (int) ((long) (n - 1) * (n - 2) / 2 % mod);
		}
		int each = ones / 3, count = 0, firstCut = 0, secondCut = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1') {
				count++;
			}
			if (count == each) {
				firstCut++;
			}
			if (count == each * 2) {
				secondCut++;
			}
		}
		return (int) ((long) firstCut * secondCut % mod);
	}
}
