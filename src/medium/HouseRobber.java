package medium;

public class HouseRobber {
	
	public static void main(String[] args) {
		int res = rob(new int[]{2, 7, 9, 3, 1});
		System.out.println(res);
	}
	
	public static int rob(int[] nums) {
		int prev = 0, cur = 0;
		for (int num : nums) {
			int temp = cur;
			cur = Math.max(prev + num, cur);
			prev = temp;
		}
		return cur;
	}
}
