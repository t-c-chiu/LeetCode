package medium;

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		int res = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
		System.out.println(res);
	}
	
	public static int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[lo] <= nums[mid]) {
				if (nums[lo] <= target && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (target <= nums[hi] && nums[mid] < target) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}
}
