package medium;

public class ReorganizeString {
	
	public static void main(String[] args) {
		String res = reorganizeString("aacccsbbbb");
		System.out.println(res);
	}
	
	public static String reorganizeString(String s) {
		int[] count = new int[26];
		int max = 0, n = s.length();
		char maxChar = 'a';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[c - 'a']++;
			if (count[c - 'a'] > max) {
				max = count[c - 'a'];
				maxChar = c;
			}
		}
		if (max > (n + 1) / 2) {
			return "";
		}
		int i = 0;
		char[] res = new char[n];
		while (count[maxChar - 'a'] > 0) {
			res[i] = maxChar;
			count[maxChar - 'a']--;
			i += 2;
		}
		for (int j = 0; j < count.length; j++) {
			while (count[j] > 0) {
				if (i >= n) {
					i = 1;
				}
				res[i] = (char) ('a' + j);
				count[j]--;
				i += 2;
			}
		}
		return String.valueOf(res);
	}
}
