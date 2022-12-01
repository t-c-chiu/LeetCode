package medium;

public class LongestBinarySubsequenceLessThanOrEqualToK {
	
	public static void main(String[] args) {
		int res = longestSubsequence("1001010", 5);
		System.out.println(res);
	}
	
	public static int longestSubsequence(String s, int k) {
		int res = 0, sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				res++;
			} else {
				sum += Math.pow(2, s.length() - i - 1);
				if (sum <= k) {
					res++;
				}
			}
		}
		return res;
	}
}
