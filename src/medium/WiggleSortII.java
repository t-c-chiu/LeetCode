package medium;

import java.util.Arrays;

public class WiggleSortII {
	public static void main(String[] args) {
		WiggleSortII wiggleSortII = new WiggleSortII();
		int[] arr1 = new int[]{1, 5, 1, 1, 6, 4};
		wiggleSortII.wiggleSort(arr1);
		for (int i : arr1)
			System.out.print(i);
		System.out.println();
		int[] arr2 = new int[]{1, 1, 1, 1, 2, 2, 2};
		wiggleSortII.wiggleSort(arr2);
		for (int i : arr2)
			System.out.print(i);
	}

	// 1 2 3 4 5 6 7 -> 3 7 2 6 1 5 4
	// 1 2 3 4 5 6 -> 3 6 2 5 1 4
	// 1 1 1 1 2 2 2 -> 1 2 1 2 1 2 1
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int length = nums.length;
		int middle = (length + 1) / 2;
		int[] temp = Arrays.copyOf(nums, length);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i % 2 == 0 ? temp[--middle] : temp[--length];
		}
	}
}
