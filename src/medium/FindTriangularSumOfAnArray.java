package medium;

public class FindTriangularSumOfAnArray {
	
	public static void main(String[] args) {
		int res = triangularSum(new int[]{1, 2, 3, 4, 5});
		System.out.println(res);
	}
	
	public static int triangularSum(int[] nums) {
		int n = nums.length;
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				nums[j] = (nums[j] + nums[j + 1]) % 10;
			}
		}
		return nums[0];
	}
}
