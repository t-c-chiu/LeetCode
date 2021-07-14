package medium;

public class FindPeakElement {
	
	public static void main(String[] args) {
		int res = findPeakElement(new int[]{1, 2});
		System.out.println(res);
	}
	
	public static int findPeakElement(int[] nums) {
		return findPeakElement(nums, 0, nums.length - 1);
		
	}
	
	private static int findPeakElement(int[] nums, int left, int right) {
		if (left == right) {
			return left;
		}
		
		int mid = (left + right) / 2;
		if (nums[mid] < nums[mid + 1]) {
			return findPeakElement(nums, mid + 1, right);
		}
		return findPeakElement(nums, left, mid);
	}

//	public static int findPeakElement(int[] nums) {
//		int left = 0;
//		int right = nums.length - 1;
//		while (left < right) {
//			int mid = (left + right) / 2;
//			if (nums[mid] > nums[mid + 1]) {
//				right = mid;
//			} else {
//				left = mid + 1;
//			}
//		}
//		return left;
//	}
}
