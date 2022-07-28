package hard;

import java.util.Arrays;

public class TotalAppealOfAString {
	
	public static void main(String[] args) {
		long res = appealSum("abbca");
		System.out.println(res);
	}
	
	public static long appealSum(String s) {
		int[] last = new int[26];
		Arrays.fill(last, -1);
		int n = s.length();
		long res = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			res += (long) (i - last[c - 'a']) * (n - i);
			last[c - 'a'] = i;
		}
		return res;
	}
	
}
