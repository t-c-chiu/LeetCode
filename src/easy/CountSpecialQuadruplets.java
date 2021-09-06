package easy;

public class CountSpecialQuadruplets {
	
	public static void main(String[] args) {
		int res = countQuadruplets(new int[]{1, 1, 1, 3, 5});
		System.out.println(res);
	}
	
	public static int countQuadruplets(int[] nums) {
		int res = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						if (nums[i] + nums[j] + nums[k] == nums[l]) {
							res++;
						}
					}
				}
			}
		}
		return res;
	}
}
