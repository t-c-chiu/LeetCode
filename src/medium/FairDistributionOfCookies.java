package medium;

public class FairDistributionOfCookies {
	
	public static void main(String[] args) {
		int res = distributeCookies(new int[]{8, 15, 10, 20, 8}, 2);
		System.out.println(res);
	}
	
	static int res = Integer.MAX_VALUE;
	
	public static int distributeCookies(int[] cookies, int k) {
		helper(cookies, 0, k, new int[k]);
		return res;
	}
	
	private static void helper(int[] cookies, int pos, int k, int[] counts) {
		if (pos == cookies.length) {
			int max = 0;
			for (int count : counts) {
				max = Math.max(max, count);
			}
			res = Math.min(res, max);
			return;
		}
		for (int i = 0; i < k; i++) {
			counts[i] += cookies[pos];
			helper(cookies, pos + 1, k, counts);
			counts[i] -= cookies[pos];
		}
	}
	
}
