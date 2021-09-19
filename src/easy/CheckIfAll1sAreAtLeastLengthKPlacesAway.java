package easy;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
	
	public static void main(String[] args) {
		boolean res = kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2);
		System.out.println(res);
	}
	
	public static boolean kLengthApart(int[] nums, int k) {
		int prev = -k - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (i - prev <= k) {
					return false;
				}
				prev = i;
			}
		}
		return true;
	}
}
