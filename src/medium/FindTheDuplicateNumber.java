package medium;

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		int res = findDuplicate(new int[]{3, 1, 3, 4, 2});
		System.out.println(res);
	}
	
	public static int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
//	public static int findDuplicate(int[] nums) {
//		int lo = 1, hi = nums.length - 1;
//		while (lo < hi) {
//			int mid = (lo + hi) / 2;
//			int count = 0;
//			for (int num : nums) {
//				if (num <= mid) {
//					count++;
//				}
//			}
//			if (count <= mid) {
//				lo = mid + 1;
//			} else {
//				hi = mid;
//			}
//		}
//		return lo;
//	}
}
