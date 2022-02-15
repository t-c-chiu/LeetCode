package medium;

public class BestSightseeingPair {
	
	public static void main(String[] args) {
		int res = maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
		System.out.println(res);
	}
	
	public static int maxScoreSightseeingPair(int[] values) {
		int res = 0, imax = values[0];
		for (int j = 1; j < values.length; j++) {
			res = Math.max(res, imax + values[j] - j);
			imax = Math.max(imax, values[j] + j);
		}
		return res;
	}
}
