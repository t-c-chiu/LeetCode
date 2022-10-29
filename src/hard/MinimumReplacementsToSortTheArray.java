package hard;

public class MinimumReplacementsToSortTheArray {
	
	public static void main(String[] args) {
		long res = minimumReplacement(new int[]{12, 9, 7, 6, 17, 19, 21});
		System.out.println(res);
	}
	
	public static long minimumReplacement(int[] nums) {
		long res = 0;
		int n = nums.length, max = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			int num = nums[i];
			if (num > max) {
				int part = num / max;
				if (num % max != 0) {
					part++;
					max = num / part;
				}
				res += part - 1;
			} else {
				max = num;
			}
		}
		return res;
	}
}
