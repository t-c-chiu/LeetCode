package easy;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
		merge(nums1, 3, new int[]{2, 5, 6}, 3);
		System.out.println(Arrays.toString(nums1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m + n - 1, p1 = m - 1, p2 = n - 1; i >= 0; i--) {
			if (p1 >= 0 && p2 >= 0) {
				if (nums1[p1] > nums2[p2]) {
					nums1[i] = nums1[p1--];
				} else {
					nums1[i] = nums2[p2--];
				}
			} else if (p1 >= 0) {
				nums1[i] = nums1[p1--];
			} else {
				nums1[i] = nums2[p2--];
			}
		}
	}
	
}
