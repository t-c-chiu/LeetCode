package easy;

public class CheckIfANumberIsMajorityElementInASortedArray {
	
	public static void main(String[] args) {
		boolean res = isMajorityElement(new int[]{2, 4, 5, 5, 5, 5, 5, 6, 6}, 5);
		System.out.println(res);
	}
	
	public static boolean isMajorityElement(int[] nums, int target) {
		int n = nums.length;
		int start = search(nums, target, true);
		if (start == -1) {
			return false;
		}
		int end = search(nums, target, false);
		return (end - start + 1) > n / 2;
	}
	
	private static int search(int[] nums, int target, boolean searchLeft) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) {
				if (searchLeft) {
					if (mid == 0 || nums[mid - 1] != target) {
						return mid;
					}
					hi = mid - 1;
				} else {
					if (mid == nums.length - 1 || nums[mid + 1] != target) {
						return mid;
					}
					lo = mid + 1;
				}
			} else if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
	
}
