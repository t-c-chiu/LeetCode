package easy;

public class FirstBadVersion {
	
	public static void main(String[] args) {
	
	}
	
	public static int firstBadVersion(int n) {
		int lo = 1, hi = n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (isBadVersion(mid)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	static boolean isBadVersion(int version) {
		return false;
	}
}
