package medium;

public class Search_in_Rotated_Sorted_Array {
	
	public static void main(String[] args) {
		Search_in_Rotated_Sorted_Array test = new Search_in_Rotated_Sorted_Array();
		int res = test.search(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 8);
		System.out.println(res);
	}
	
	public int search(int[] nums, int target) {
		int length = nums.length;
		if (length == 0) {
			return -1;
		}
		
		int left = 0, right = length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		int lowest = left;
		boolean searchLowestSide = nums[lowest] <= target && target <= nums[length - 1];
		left = searchLowestSide ? lowest : 0;
		right = searchLowestSide ? length - 1 : lowest - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
