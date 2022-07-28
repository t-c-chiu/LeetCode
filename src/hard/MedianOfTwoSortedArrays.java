package hard;

public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		double res = findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6, 7});
		System.out.println(res);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int lo = 0, hi = m;
		while (lo <= hi) {
			int partition1 = (lo + hi) / 2;
			int partition2 = (m + n + 1) / 2 - partition1;
			int left1Max = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
			int left2Max = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
			int right1Min = partition1 == m ? Integer.MAX_VALUE : nums1[partition1];
			int right2Min = partition2 == n ? Integer.MAX_VALUE : nums2[partition2];
			if (left1Max <= right2Min && left2Max <= right1Min) {
				if ((m + n) % 2 == 0) {
					return (Math.max(left1Max, left2Max) + Math.min(right1Min, right2Min)) / 2d;
				} else {
					return Math.max(left1Max, left2Max);
				}
			}
			if (left1Max > right2Min) {
				hi = partition1 - 1;
			} else if (left2Max > right1Min) {
				lo = partition1 + 1;
			}
		}
		return -1;
	}
}
