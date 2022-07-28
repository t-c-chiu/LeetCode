package medium;

public class JumpGameII {
	
	public static void main(String[] args) {
		int res = jump(new int[]{2, 3, 1, 1, 4});
		System.out.println(res);
	}
	
	public static int jump(int[] nums) {
		int n = nums.length, i = 0, end = 0, res = 0;
		while (i < n && end < n - 1) {
			res++;
			int newEnd = end;
			while (i < n && i <= end) {
				newEnd = Math.max(newEnd, i + nums[i]);
				i++;
			}
			if (newEnd == end) {
				return -1;
			}
			end = newEnd;
		}
		return res;
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
