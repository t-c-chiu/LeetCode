package medium;

import java.util.Arrays;

public class BagOfTokens {
	
	public static void main(String[] args) {
		int res = bagOfTokensScore(new int[]{71, 55, 82}, 54);
		System.out.println(res);
	}
	
	public static int bagOfTokensScore(int[] tokens, int power) {
		Arrays.sort(tokens);
		int left = 0;
		int right = tokens.length - 1;
		int score = 0;
		int res = 0;
		while (left <= right) {
			if (power >= tokens[left]) {
				power -= tokens[left];
				left++;
				score++;
				res = Math.max(res, score);
			} else if (score > 0) {
				power += tokens[right];
				right--;
				score--;
			} else {
				break;
			}
		}
		return res;
	}
}
