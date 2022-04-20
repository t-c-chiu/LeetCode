package medium;

public class ReorganizeString {
	
	public static void main(String[] args) {
		String res = reorganizeString("aacccsbbbb");
		System.out.println(res);
	}
	
	public static String reorganizeString(String s) {
		int[] count = new int[26];
		int len = s.length();
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < len; i++) {
			int j = s.charAt(i) - 'a';
			count[j]++;
			if (count[j] > max) {
				max = count[j];
				maxIndex = j;
			}
		}
		
		if (count[maxIndex] > (len + 1) / 2) {
			return "";
		}
		
		char[] res = new char[len];
		int i = 0;
		while (count[maxIndex] > 0) {
			res[i] = (char) (maxIndex + 'a');
			count[maxIndex]--;
			i += 2;
		}
		for (int j = 0; j < count.length; j++) {
			while (count[j] > 0) {
				if (i >= len) {
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
