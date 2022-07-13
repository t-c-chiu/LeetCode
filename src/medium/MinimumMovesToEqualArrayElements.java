package medium;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
	
	public static void main(String[] args) {
		int res = minMoves(new int[]{1, 2, 3});
		System.out.println(res);
	}
	
	public static int minMoves(int[] nums) {
		return Arrays.stream(nums).sum() - Arrays.stream(nums).min().getAsInt() * nums.length;
	}
}
