package medium;

public class SubarrayProductLessThanK {
	
	public static void main(String[] args) {
		SubarrayProductLessThanK test = new SubarrayProductLessThanK();
		
		int ans = test.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 0);
		System.out.println(ans);
	}
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int res = 0;
		int prod = 1;
		for (int i = 0, j = 0; j < nums.length; j++) {
			prod *= nums[j];
			while (i <= j && prod >= k) {
				prod /= nums[i++];
			}
			res += j + 1 - i;
		}
		return res;
	}
}
