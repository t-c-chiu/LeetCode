package medium;

public class FindMinimumInRotatedSortedArray {
	
	public static void main(String[] args) {
		int res = findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
		System.out.println(res);
	}
	
	public static int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid > 0 && nums[mid] < nums[mid - 1]) {
				return nums[mid];
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return nums[left];
	}
}
