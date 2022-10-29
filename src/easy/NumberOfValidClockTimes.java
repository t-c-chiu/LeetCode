package easy;

public class NumberOfValidClockTimes {
	
	public static void main(String[] args) {
	
	}
	
	public static int countTime(String time) {
		int res = 1;
		char c1 = time.charAt(0), c2 = time.charAt(1), c3 = time.charAt(3), c4 = time.charAt(4);
		if (c1 == '?' || c2 == '?') {
			if (c1 == '?' && c2 == '?') {
				res *= 24;
			} else if (c1 == '?') {
				res *= c2 <= '3' ? 3 : 2;
			} else {
				res *= c1 <= '1' ? 10 : 4;
			}
		}
		if (c3 == '?') {
			res *= 6;
		}
		if (c4 == '?') {
			res *= 10;
		}
		return res;
	}
}
