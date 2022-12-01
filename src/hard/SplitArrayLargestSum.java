package hard;

public class SplitArrayLargestSum {
	
	public static void main(String[] args) {
		int res = splitArray(new int[]{7, 2, 5, 10, 8}, 2);
		System.out.println(res);
	}
	
	public static int splitArray(int[] nums, int k) {
		int lo = Integer.MIN_VALUE, hi = 0;
		for (int num : nums) {
			lo = Math.max(lo, num);
			hi += num;
		}
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (canSplit(nums, mid, k)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	private static boolean canSplit(int[] nums, int target, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
			if (sum > target) {
				sum = num;
				k--;
				if (k < 1) {
					return false;
				}
			}
		}
		return true;
	}
}
