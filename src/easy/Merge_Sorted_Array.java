package easy;

import java.util.Arrays;

public class Merge_Sorted_Array {
	public static void main(String[] args) {
		Merge_Sorted_Array test = new Merge_Sorted_Array();
		int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
		test.merge(nums1, 3, new int[]{2, 5, 6}, 3);
		for (int i : nums1) {
			System.out.print(i);
		}
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0)
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		while (j >= 0)
			nums1[k--] = nums2[j--];
	}
	
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
			nums1[i] = nums2[j];
		}
		Arrays.sort(nums1);
	}
}
