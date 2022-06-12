package medium;

public class MissingElementInSortedArray {
	
	public static void main(String[] args) {
		int res = missingElement(new int[]{4, 7, 9, 10}, 5);
		System.out.println(res);
	}
	
	public static int missingElement(int[] nums, int k) {
		int n = nums.length;
		for (int i = nums[0], j = 0; i <= nums[n - 1] && j < n; i++) {
			if (i == nums[j]) {
				j++;
			} else if (--k == 0) {
				return i;
			}
		}
		return nums[n - 1] + k;
	}
	
}
