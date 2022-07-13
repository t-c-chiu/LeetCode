package medium;

import java.util.Arrays;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
	
	public static void main(String[] args) {
		int res = minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3);
		System.out.println(res);
	}
	
	public static int minSumOfLengths(int[] arr, int target) {
		int sum = 0, n = arr.length, res = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
		int[] best = new int[n];
		Arrays.fill(best, Integer.MAX_VALUE);
		for (int right = 0, left = 0; right < n; right++) {
			sum += arr[right];
			while (sum > target) {
				sum -= arr[left++];
			}
			if (sum == target) {
				if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
					res = Math.min(res, best[left - 1] + right - left + 1);
				}
				bestSoFar = Math.min(bestSoFar, right - left + 1);
			}
			best[right] = bestSoFar;
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
//	public static int minSumOfLengths(int[] arr, int target) {
//		int n = arr.length, sum = 0, res = Integer.MAX_VALUE;
//		int[] prefix = new int[n];
//		int[] suffix = new int[n];
//		Arrays.fill(prefix, n);
//		Arrays.fill(suffix, n);
//		for (int right = 0, left = 0; right < n - 1; right++) {
//			prefix[right + 1] = prefix[right];
//			sum += arr[right];
//			while (sum > target) {
//				sum -= arr[left++];
//			}
//			if (sum == target) {
//				prefix[right + 1] = Math.min(prefix[right + 1], right - left + 1);
//			}
//		}
//		sum = 0;
//		for (int left = n - 1, right = n - 1; left >= 0; left--) {
//			if (left < n - 1) {
//				suffix[left] = suffix[left + 1];
//			}
//			sum += arr[left];
//			while (sum > target) {
//				sum -= arr[right--];
//			}
//			if (sum == target) {
//				suffix[left] = Math.min(suffix[left], right - left + 1);
//			}
//		}
//		for (int i = 1; i < n - 1; i++) {
//			res = Math.min(res, prefix[i] + suffix[i]);
//		}
//		return res > n ? -1 : res;
//	}
}
