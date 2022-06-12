package medium;

import java.util.*;

public class MaximumProductOfWordLengths {
	
	public static void main(String[] args) {
		int res = maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
		System.out.println(res);
	}
	
	public static int maxProduct(String[] words) {
		int n = words.length, res = 0;
		int[] mask = new int[n];
		for (int i = 0; i < n; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				mask[i] |= 1 << (word.charAt(j) - 'a');
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((mask[i] & mask[j]) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return res;
	}
}
