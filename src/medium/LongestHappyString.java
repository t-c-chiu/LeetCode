package medium;

public class LongestHappyString {
	
	public static void main(String[] args) {
		String res = longestDiverseString(7, 1, 0);
		System.out.println(res);
	}
	
	public static String longestDiverseString(int a, int b, int c) {
		int size = a + b + c, aUsed = 0, bUsed = 0, cUsed = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (a > 0 && a >= b && a >= c && aUsed < 2 || bUsed == 2 && a > 0 || cUsed == 2 && a > 0) {
				sb.append('a');
				a--;
				aUsed++;
				bUsed = 0;
				cUsed = 0;
			} else if (b > 0 && b >= a && b >= c && bUsed < 2 || aUsed == 2 && b > 0 || cUsed == 2 && b > 0) {
				sb.append('b');
				b--;
				bUsed++;
				aUsed = 0;
				cUsed = 0;
			} else if (c > 0 && c >= a && c >= b && cUsed < 2 || aUsed == 2 && c > 0 || bUsed == 2 && c > 0) {
				sb.append('c');
				c--;
				cUsed++;
				aUsed = 0;
				bUsed = 0;
			}
		}
		return sb.toString();
	}
//	public static String longestDiverseString(int a, int b, int c) {
//		return helper(a, b, c, "a", "b", "c");
//	}
//
//	private static String helper(int a, int b, int c, String aa, String bb, String cc) {
//		if (b > a) {
//			return helper(b, a, c, bb, aa, cc);
//		}
//		if (c > b) {
//			return helper(a, c, b, aa, cc, bb);
//		}
//		if (b == 0) {
//			return aa.repeat(Math.min(2, a));
//		}
//		int aCount = Math.min(2, a), bCount = a - aCount >= b ? 1 : 0;
//		return aa.repeat(aCount) + bb.repeat(bCount) + helper(a - aCount, b - bCount, c, aa, bb, cc);
//	}
	
}
