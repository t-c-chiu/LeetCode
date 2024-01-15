package medium;

public class MinimumMovesToCaptureTheQueen {
	
	public static void main(String[] args) {
	
	}
	
	public static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
		return check(a, b, c, d, e, f, -1, 0)
				|| check(a, b, c, d, e, f, 1, 0)
				|| check(a, b, c, d, e, f, 0, -1)
				|| check(a, b, c, d, e, f, 0, 1)
				|| check(c, d, a, b, e, f, 1, 1)
				|| check(c, d, a, b, e, f, 1, -1)
				|| check(c, d, a, b, e, f, -1, 1)
				|| check(c, d, a, b, e, f, -1, -1)
				? 1 : 2;
	}
	
	private static boolean check(int a, int b, int c, int d, int e, int f, int i, int j) {
		int x = e + i, y = f + j;
		if (x < 1 || x > 8 || y < 1 || y > 8 || x == c && y == d) {
			return false;
		}
		if (x == a && y == b) {
			return true;
		}
		return check(a, b, c, d, x, y, i, j);
	}
	
}
