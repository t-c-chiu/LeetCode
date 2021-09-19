package easy;

import java.util.*;

public class MaximumNumberOfBalloons {
	
	public static void main(String[] args) {
		int res = maxNumberOfBalloons("leetcode");
		System.out.println(res);
	}
	
	public static int maxNumberOfBalloons(String text) {
		int[] chars = new int[26];
		for (char c : text.toCharArray()) {
			chars[c - 'a']++;
		}
		int res = chars[1];
		res = Math.min(res, chars[0]);
		res = Math.min(res, chars[11] / 2);
		res = Math.min(res, chars[14] / 2);
		res = Math.min(res, chars[13]);
		return res;
	}
}
