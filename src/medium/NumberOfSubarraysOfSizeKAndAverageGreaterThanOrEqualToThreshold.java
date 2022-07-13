package medium;

public class NumberOfSubarraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
	
	public static void main(String[] args) {
		int res = numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5);
		System.out.println(res);
	}
	
	public static int numOfSubarrays(int[] arr, int k, int threshold) {
		int res = 0, sum = 0;
		threshold *= k;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (i < k - 1) {
				continue;
			}
			if (i >= k) {
				sum -= arr[i - k];
			}
			if (sum >= threshold) {
				res++;
			}
		}
		return res;
	}
}
