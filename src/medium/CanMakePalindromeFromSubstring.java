package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanMakePalindromeFromSubstring {
	
	public static void main(String[] args) {
		List<Boolean> res = canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}});
		System.out.println(res);
	}
	
	public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> res = new ArrayList<>();
		int n = s.length();
		int[] count = new int[26];
		int[][] preCount = new int[n][26];
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
			preCount[i] = Arrays.copyOf(count, 26);
		}
		for (int[] query : queries) {
			int unique = 0;
			for (int i = 0; i < 26; i++) {
				unique += (preCount[query[1]][i] - (query[0] > 0 ? preCount[query[0] - 1][i] : 0)) % 2;
			}
			res.add(unique / 2 <= query[2]);
		}
		return res;
	}
}
