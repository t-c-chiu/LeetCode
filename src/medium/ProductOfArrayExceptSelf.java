package medium;

public class ProductOfArrayExceptSelf {
	
	public static void main(String[] args) {
		for (int i : productExceptSelf(new int[]{1, 2, 3, 4}))
			System.out.println(i);
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length, product = 1;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = product;
			product *= nums[i];
		}
		product = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= product;
			product *= nums[i];
		}
		return res;
	}
}
