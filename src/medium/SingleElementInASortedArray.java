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
		
		int left = 0, right = n - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}

//	public static int singleNonDuplicate(int[] nums) {
//		int n = nums.length;
//		if (n == 1) {
//			return nums[0];
//		}
//
//		int left = 0, right = n - 1;
//		while (left <= right) {
//			int mid = (left + right) / 2;
//			if (mid > 0 && nums[mid] == nums[mid - 1]) {
//				if (mid % 2 == 0) {
//					right = mid - 2;
//				} else {
//					left = mid + 1;
//				}
//			} else if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
//				if (mid % 2 == 1) {
//					right = mid - 1;
//				} else {
//					left = mid + 2;
//				}
//			} else {
//				return nums[mid];
//			}
//		}
//		return nums[left];
//	}
}
