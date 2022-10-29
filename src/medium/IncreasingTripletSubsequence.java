package medium;

public class IncreasingTripletSubsequence {
	
	public static void main(String[] args) {
		boolean res = increasingTriplet(new int[]{2, 1, 5, 0, 4, 6});
		System.out.println(res);
	}
	
	public static boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= small) {
				small = num;
			} else if (num <= big) {
				big = num;
			} else {
				return true;
			}
		}
		return false;
	}
}
