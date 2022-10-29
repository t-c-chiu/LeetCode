package medium;

public class BitwiseXOROfAllPairings {
	
	public static void main(String[] args) {
		int res = xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0});
		System.out.println(res);
	}
	
	public static int xorAllNums(int[] nums1, int[] nums2) {
		int n = nums1.length, m = nums2.length, res = 0;
		if (n % 2 == 1) {
			for (int i : nums2) {
				res ^= i;
			}
		}
		if (m % 2 == 1) {
			for (int i : nums1) {
				res ^= i;
			}
		}
		return res;
	}
}
