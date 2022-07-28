package medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
	
	public static void main(String[] args) {
		int[] res = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int n = nums.length, start = -1, end = -1, lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2, num = nums[mid];
			if (num == target && (mid == 0 || nums[mid - 1] < target)) {
				start = mid;
				break;
			} else if (num < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		lo = 0;
		hi = n - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2, num = nums[mid];
			if (num == target && (mid == n - 1 || nums[mid + 1] > target)) {
				end = mid;
				break;
			} else if (num > target) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return new int[]{start, end};
	}
}
