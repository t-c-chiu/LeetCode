package easy;

public class BinarySearch {
	
	public static void main(String[] args) {
		int res = search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
		System.out.println(res);
	}
	
	public static int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
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
}
