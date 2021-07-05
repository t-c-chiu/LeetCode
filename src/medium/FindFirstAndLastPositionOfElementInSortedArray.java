package medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
	
	public static void main(String[] args) {
		int[] res = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	static int start = -1;
	static int end = -1;
	
	public static int[] searchRange(int[] nums, int target) {
		searchRange(nums, target, 0, nums.length - 1);
		return new int[]{start, end};
	}
	
	private static void searchRange(int[] nums, int target, int lo, int hi) {
		if (lo > hi) {
			return;
		}
		
		int mid = (lo + hi) / 2;
		if (nums[mid] == target) {
			if (start == -1 || start > mid) {
				start = mid;
			}
			if (end == -1 || end < mid) {
				end = mid;
			}
			searchRange(nums, target, lo, mid - 1);
			searchRange(nums, target, mid + 1, hi);
		} else if (nums[mid] < target) {
			searchRange(nums, target, mid + 1, hi);
		} else {
			searchRange(nums, target, lo, mid - 1);
		}
	}
}
