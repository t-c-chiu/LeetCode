package medium;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		for (int i : new ProductOfArrayExceptSelf().productExceptSelf2(new int[]{1, 2, 3, 4}))
			System.out.println(i);
	}

	// 1,1,2,6 * 24,12,4,1
	// 24,12,8,6
	public int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		int total = 1;
		int zeroCount = 0;
		for (int i = 0; i < length; i++) {
			int num = nums[i];
			if (num == 0)
				zeroCount++;
			else
				total *= nums[i];
		}
		if (zeroCount > 1)
			return result;
		if (zeroCount == 1) {
			for (int i = 0; i < length; i++) {
				int num = nums[i];
				if (num == 0)
					result[i] = total;
				else
					result[i] = 0;
			}
		} else {
			for (int i = 0; i < length; i++)
				result[i] = total / nums[i];
		}
		return result;
	}

	public int[] productExceptSelf2(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		result[0] = 1;

		for (int i = 1; i < length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = length - 1; i >= 0; i--) {
			result[i] *= right;
			right *= nums[i];
		}
		return result;
	}
}
