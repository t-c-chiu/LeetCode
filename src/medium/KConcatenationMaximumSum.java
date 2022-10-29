package medium;

public class KConcatenationMaximumSum {
	
	public static void main(String[] args) {
		int res = kConcatenationMaxSum(new int[]{1, -2, 1}, 5);
		System.out.println(res);
	}
	
	public static int kConcatenationMaxSum(int[] arr, int k) {
		int max = maxSubArraySum(arr), mod = (int) 1e9 + 7;
		if (k == 1) {
			return max;
		}
		int n = arr.length;
		long maxPrefix = 0, maxSuffix = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			maxPrefix = Math.max(maxPrefix, sum);
		}
		sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			sum += arr[i];
			maxSuffix = Math.max(maxSuffix, sum);
		}
		if (sum > 0) {
			return (int) (Math.max(sum * (k - 2) % mod + maxPrefix % mod + maxSuffix % mod, max % mod) % mod);
		}
		return (int) Math.max(maxPrefix % mod + maxSuffix % mod, max % mod);
	}
	
	private static int maxSubArraySum(int[] arr) {
		int max = 0, sum = 0;
		for (int i : arr) {
			sum = Math.max(sum + i, i);
			max = Math.max(max, sum);
		}
		return max;
	}
}
