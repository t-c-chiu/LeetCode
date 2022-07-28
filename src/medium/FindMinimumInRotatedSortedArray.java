package medium;

public class FindMinimumInRotatedSortedArray {
	
	public static void main(String[] args) {
		int res = findMin(new int[]{4, 5, 6, 1, 2, 3});
		System.out.println(res);
	}
	
	public static int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return nums[lo];
	}
}
