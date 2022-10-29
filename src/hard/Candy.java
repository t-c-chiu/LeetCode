package hard;

public class Candy {
	
	public static void main(String[] args) {
		int res = candy(new int[]{1, 2, 2});
		System.out.println(res);
	}
	
	public static int candy(int[] ratings) {
		int n = ratings.length;
		int[] nums = new int[n];
		nums[0] = 1;
		for (int i = 1; i < n; i++) {
			nums[i] = ratings[i] > ratings[i - 1] ? nums[i - 1] + 1 : 1;
		}
		int res = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				nums[i] = Math.max(nums[i], nums[i + 1] + 1);
			}
			res += nums[i];
		}
		return res;
	}
}
