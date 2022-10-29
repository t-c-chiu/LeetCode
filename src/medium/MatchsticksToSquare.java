package medium;

import java.util.Arrays;

public class MatchsticksToSquare {
	
	public static void main(String[] args) {
		boolean res = makesquare(new int[]{1, 1, 2, 2, 2});
		System.out.println(res);
	}
	
	public static boolean makesquare(int[] matchsticks) {
		int sum = Arrays.stream(matchsticks).sum();
		if (sum % 4 != 0) {
			return false;
		}
		Arrays.sort(matchsticks);
		return helper(matchsticks, sum / 4, matchsticks.length - 1, new int[4]);
	}
	
	private static boolean helper(int[] matchsticks, int side, int index, int[] sum) {
		if (index < 0) {
			return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
		}
		for (int i = 0; i < 4; i++) {
			if (sum[i] + matchsticks[index] <= side) {
				sum[i] += matchsticks[index];
				if (helper(matchsticks, side, index - 1, sum)) {
					return true;
				}
				sum[i] -= matchsticks[index];
			}
		}
		return false;
	}
	
}
