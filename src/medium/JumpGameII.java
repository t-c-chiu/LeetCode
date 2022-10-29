package medium;

public class JumpGameII {
	
	public static void main(String[] args) {
		int res = jump(new int[]{2, 3, 1, 1, 4});
		System.out.println(res);
	}
	
	public static int jump(int[] nums) {
		int n = nums.length, i = 0, end = 0, jump = 0;
		while (end < n - 1) {
			jump++;
			int newEnd = end;
			while (i < n && i <= end) {
				newEnd = Math.max(newEnd, i + nums[i]);
				i++;
			}
			end = newEnd;
		}
		return jump;
	}
	
}
