package easy;

public class LongestAlternatingSubarray {
	
	public static void main(String[] args) {
		int res = alternatingSubarray(new int[]{2, 3, 4, 3, 4});
		System.out.println(res);
	}
	
	public static int alternatingSubarray(int[] nums) {
		int n = nums.length, res = -1;
		for (int i = 1; i < n; i++) {
			int num1 = nums[i - 1], num2 = nums[i];
			if (num2 - 1 == num1) {
				int len = 2;
				for (int k = i + 1; k < n; k++) {
					if ((k - i) % 2 == 1 && nums[k] == num1 || (k - i) % 2 == 0 && nums[k] == num2) {
						len++;
					} else {
						break;
					}
				}
				res = Math.max(res, len);
			}
		}
		return res;
	}
	
}
