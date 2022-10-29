package medium;

public class BestSightseeingPair {
	
	public static void main(String[] args) {
		int res = maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
		System.out.println(res);
	}
	
	// values[i] + values[j] + i - j
	public static int maxScoreSightseeingPair(int[] values) {
		int res = 0, maxi = values[0];
		for (int i = 1; i < values.length; i++) {
			res = Math.max(res, maxi + values[i] - i);
			maxi = Math.max(maxi, values[i] + i);
		}
		return res;
	}
}
