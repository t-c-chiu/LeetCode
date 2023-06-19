package medium;

public class MaximumValueAtAGivenIndexInABoundedArray {
	
	public static void main(String[] args) {
		int res = maxValue(6, 1, 10);
		System.out.println(res);
	}
	
	public static int maxValue(int n, int index, int maxSum) {
		if (n == 1) {
			return maxSum;
		}
		int lo = 1, hi = maxSum;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			long sum = sum(mid, index + 1) + sum(mid, n - index) - mid;
			if (sum <= maxSum) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo - 1;
	}
	
	private static long sum(int num, int len) {
		int h = Math.min(num, len);
		long sum = (long) (num + (num - h + 1)) * h / 2;
		if (len > num) {
			sum += len - num;
		}
		return sum;
	}
	
}
