package hard;

public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		double res = findMedianSortedArrays(new int[]{1, 3, 5, 8, 9}, new int[]{2, 10, 11, 13});
		System.out.println(res);
	}
	
	/**
	 * 1 3 5 | 8 9
	 * 2 10 | 11 13
	 *
	 * 1 3 5 8 | 9
	 * 2 | 10 11 13
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if (len1 > len2) {
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int start = 0;
		int end = len1;
		while (start <= end) {
			int partition1 = (start + end) / 2;
			int partition2 = (len1 + len2 + 1) / 2 - partition1;
			int left1Max = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
			int left2Max = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
			int right1Min = partition1 == len1 ? Integer.MAX_VALUE : nums1[partition1];
			int right2Min = partition2 == len2 ? Integer.MAX_VALUE : nums2[partition2];
			if (left1Max <= right2Min && left2Max <= right1Min) {
				if ((len1 + len2) % 2 == 0) {
					return (Math.max(left1Max, left2Max) + Math.min(right1Min, right2Min)) / 2d;
				} else {
					return Math.max(left1Max, left2Max);
				}
			} else if (left1Max > right2Min) {
				end = partition1 - 1;
			} else if (left2Max > right1Min) {
				start = partition1 + 1;
			}
		}
		return -1;
	}
}
