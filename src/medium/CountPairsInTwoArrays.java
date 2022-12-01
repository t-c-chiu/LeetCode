package medium;

import java.util.Arrays;

public class CountPairsInTwoArrays {
	
	public static void main(String[] args) {
		long res = countPairs(new int[]{2, 1, 2, 1}, new int[]{1, 2, 1, 2});
		System.out.println(res);
	}
	
	//nums1[i] + nums1[j] > nums2[i] + nums2[j]
	//nums1[i] - nums2[i] > nums2[j] - nums1[j]
	//nums1[i] - nums2[i] + nums1[j] - nums2[j] > 0
	public static long countPairs(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int[] diff = new int[n];
		for (int i = 0; i < n; i++) {
			diff[i] = nums1[i] - nums2[i];
		}
		Arrays.sort(diff);
		long res = 0;
		for (int i = 0; i < n; i++) {
			int lo = i + 1, hi = n;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (diff[i] + diff[mid] <= 0) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			}
			res += n - lo;
		}
		return res;
	}
}
