package medium;

public class JumpGameII {
	
	public static void main(String[] args) {
		int res = jump(new int[]{2, 3, 1, 1, 4});
		System.out.println(res);
	}
	
	public static int jump(int[] nums) {
		int jump = 0, farthest = 0, currentEnd = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == currentEnd) {
				jump++;
				currentEnd = farthest;
			}
		}
		return jump;
	}

//	public static int jump(int[] nums) {
//		if (nums.length == 1) {
//			return 0;
//		}
//		return jump(nums, 0);
//	}
//
//	private static int jump(int[] nums, int i) {
//		int n = nums.length;
//		if (i + nums[i] >= n - 1) {
//			return 1;
//		}
//
//		int next = 0;
//		int farthest = 0;
//		for (int j = 1; j <= nums[i] && i + j < n; j++) {
//			if (i + j + nums[i + j] > farthest) {
//				farthest = i + j + nums[i + j];
//				next = i + j;
//			}
//		}
//		return 1 + jump(nums, next);
//	}
}
