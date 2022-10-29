package medium;

public class LongestIdealSubsequence {
	
	public static void main(String[] args) {
		int res = longestIdealString("acfgbd", 2);
		System.out.println(res);
	}
	
	public static int longestIdealString(String s, int k) {
		int res = 0;
		int[] max = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int temp = 1;
			for (int j = Math.max('a', c - k); j <= Math.min('z', c + k); j++) {
				temp = Math.max(temp, max[j - 'a'] + 1);
			}
			max[c - 'a'] = temp;
			res = Math.max(res, temp);
		}
		return res;
	}
}
