package medium;

public class ReorganizeString {
	
	public static void main(String[] args) {
		String res = reorganizeString("aacccsbbbb");
		System.out.println(res);
	}
	
	public static String reorganizeString(String s) {
		int length = s.length();
		int[] count = new int[26];
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			count[c - 'a']++;
			if (count[c - 'a'] > max) {
				max = count[c - 'a'];
				maxIndex = c - 'a';
			}
		}
		
		if (max > (length + 1) / 2) {
			return "";
		}
		char[] res = new char[length];
		int i = 0;
		while (count[maxIndex] > 0) {
			res[i] = (char) (maxIndex + 'a');
			count[maxIndex]--;
			i += 2;
		}
		for (int j = 0; j < count.length; j++) {
			while (count[j] > 0) {
				if (i >= res.length) {
					i = 1;
				}
				res[i] = (char) (j + 'a');
				count[j]--;
				i += 2;
			}
		}
		return String.valueOf(res);
	}
}
