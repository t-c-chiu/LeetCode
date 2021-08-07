package medium;

public class LargestSumOfAverages {
	
	public static void main(String[] args) {
		double res = largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3);
		System.out.println(res);
	}
	
	public static double largestSumOfAverages(int[] nums, int k) {
		int n = nums.length;
		double[][] memo = new double[n][k + 1];
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			memo[i][1] = sum / (i + 1);
		}
		return largestSumOfAverages(n - 1, k, nums, memo);
	}
	
	private static double largestSumOfAverages(int end, int k, int[] nums, double[][] memo) {
		if (memo[end][k] > 0) {
			return memo[end][k];
		}
		double sum = 0;
		for (int i = end; i >= k - 1; i--) {
			sum += nums[i];
			memo[end][k] = Math.max(memo[end][k], sum / (end - i + 1) + largestSumOfAverages(i - 1, k - 1, nums, memo));
		}
		return memo[end][k];
	}

//	public static double largestSumOfAverages(int[] nums, int k) {
//		int n = nums.length;
//		double[][] avgs = new double[n][n];
//		for (int i = 0; i < n; i++) {
//			double sum = 0;
//			for (int j = i; j < n; j++) {
//				sum += nums[j];
//				avgs[i][j] = sum / (j - i + 1);
//			}
//		}
//		return largestSumOfAverages(avgs, k, 0, new double[n][n][k + 1]);
//	}
//
//	private static double largestSumOfAverages(double[][] avgs, int k, int start, double[][][] memo) {
//		int n = avgs.length;
//		if (memo[start][n - 1][k] > 0) {
//			return memo[start][n - 1][k];
//		}
//
//		if (k == 1) {
//			return avgs[start][n - 1];
//		}
//		double res = 0;
//		for (int i = start; i < n - k + 1; i++) {
//			res = Math.longest(res, avgs[start][i] + largestSumOfAverages(avgs, k - 1, i + 1, memo));
//		}
//		memo[start][n - 1][k] = res;
//		return res;
//	}
}
