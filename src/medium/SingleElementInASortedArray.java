package medium;

public class SingleElementInASortedArray {
	
	public static void main(String[] args) {
		int res = singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11});
		System.out.println(res);
	}
	
	public static int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		int lo = 0, hi = n - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (mid % 2 == 0) {
				if (nums[mid] == nums[mid + 1]) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			} else {
				if (nums[mid] == nums[mid - 1]) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			}
		}
		return nums[lo];
	}
	
}
