package easy;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
	
	public static void main(String[] args) {
		int res = countKDifference(new int[]{3, 2, 1, 5, 4}, 2);
		System.out.println(res);
	}
	
	public static int countKDifference(int[] nums, int k) {
		int[] count = new int[101];
		for (int num : nums) {
			count[num]++;
		}
		int res = 0;
		for (int i = 1; i <= 100 - k; i++) {
			res += count[i] * count[i + k];
		}
		return res;
	}

//	public static int countKDifference(int[] nums, int k) {
//		int res = 0, n = nums.length;
//		for (int i = 0; i < n; i++) {
//			for (int j = i + 1; j < n; j++) {
//				if (Math.abs(nums[i] - nums[j]) == k) {
//					res++;
//				}
//			}
//		}
//		return res;
//	}
}
