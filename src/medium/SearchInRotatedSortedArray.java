package medium;

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		int res = search(new int[]{4, 5, 6, 0, 1, 2, 3}, 6);
		System.out.println(res);
	}
	
	public static int search(int[] nums, int target) {
		int minIndex = searchMin(nums), n = nums.length;
		if (nums[minIndex] <= target && target <= nums[n - 1]) {
			return search(nums, minIndex, n - 1, target);
		}
		return search(nums, 0, minIndex - 1, target);
	}
	
	private static int search(int[] nums, int lo, int hi, int target) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
	
	private static int searchMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}


//	public static int search(int[] nums, int target) {
//		int lo = 0, hi = nums.length - 1;
//		while (lo <= hi) {
//			int mid = (lo + hi) / 2;
//			if (nums[mid] == target) {
//				return mid;
//			} else if (nums[lo] <= nums[mid]) {
//				if (nums[lo] <= target && target < nums[mid]) {
//					hi = mid - 1;
//				} else {
//					lo = mid + 1;
//				}
//			} else {
//				if (nums[mid] < target && target <= nums[hi]) {
//					lo = mid + 1;
//				} else {
//					hi = mid - 1;
//				}
//			}
//		}
//		return -1;
//	}
}
