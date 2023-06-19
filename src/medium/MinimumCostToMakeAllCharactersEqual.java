package medium;

public class MinimumCostToMakeAllCharactersEqual {
	
	public static void main(String[] args) {
		long res = minimumCost("001101");
		System.out.println(res);
	}
	
	/**
	 * 001101
	 */
	public static long minimumCost(String s) {
		long res = 0;
		int n = s.length(), mid = n / 2;
		char target = s.charAt(mid);
		for (int i = mid; i >= 0; i--) {
			if (s.charAt(i) != target) {
				res += i + 1;
				target = s.charAt(i);
			}
		}
		target = s.charAt(mid);
		for (int i = mid; i < n; i++) {
			if (s.charAt(i) != target) {
				res += n - i;
				target = s.charAt(i);
			}
		}
		return res;
	}
}
