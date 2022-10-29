package medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
	
	public static void main(String[] args) {
		int[] res = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int start = search(nums, target, true);
		if (start == -1) {
			return new int[]{-1, -1};
		}
		int end = search(nums, target, false);
		return new int[]{start, end};
	}
	
	private static int search(int[] nums, int target, boolean first) {
		int lo = 0, hi = nums.length - 1, idx = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] < target) {
				lo = mid + 1;
			} else if (nums[mid] > target) {
				hi = mid - 1;
			} else {
				idx = mid;
				if (first) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}
		return idx;
	}
	
	
}
