package medium;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
	
	public static void main(String[] args) {
		String res = getSmallestString(3, 27);
		System.out.println(res);
	}
	
	public static String getSmallestString(int n, int k) {
		char[] res = new char[n];
		Arrays.fill(res, 'a');
		for (int i = n - 1; i >= 0 && k > i; i--) {
			int val = Math.min(26, k - i);
			res[i] = (char) ('a' + val - 1);
			k -= val;
		}
		return String.valueOf(res);
	}
	
}
