package easy;

public class MissingNumber {
	
	public static void main(String[] args) {
		int res = missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
		System.out.println(res);
	}
	
	public static int missingNumber(int[] nums) {
		int res = 0, n = nums.length;
		for (int i = 0; i < n; i++) {
			res ^= i ^ nums[i];
		}
		return res ^ n;
	}
}
