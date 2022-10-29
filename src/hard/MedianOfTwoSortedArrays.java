package hard;

public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		double res = findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4});
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
			int left1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
			int right1 = partition1 == m ? Integer.MAX_VALUE : nums1[partition1];
			int left2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
			int right2 = partition2 == n ? Integer.MAX_VALUE : nums2[partition2];
			if (left1 <= right2 && left2 <= right1) {
				if ((m + n) % 2 == 0) {
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2d;
				} else {
					return Math.max(left1, left2);
				}
			} else if (left1 > right2) {
				hi = partition1 - 1;
			} else {
				lo = partition1 + 1;
			}
		}
		return -1;
	}
}
