package medium;

import java.util.*;

public class MinimumNumberOfKeypresses {
	
	public static void main(String[] args) {
		int res = minimumKeypresses("abcdefghijkl");
		System.out.println(res);
	}
	
	public static int minimumKeypresses(String s) {
		Integer[] count = new Integer[26];
		Arrays.fill(count, 0);
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		Arrays.sort(count, Comparator.reverseOrder());
		int res = 0;
		for (int i = 0; i < count.length; i++) {
			res += count[i] * (i / 9 + 1);
		}
		return res;
	}
}
