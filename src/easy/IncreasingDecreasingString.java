package easy;

public class IncreasingDecreasingString {
	
	public static void main(String[] args) {
		String res = sortString("aaaabbbbcccc");
		System.out.println(res);
	}
	
	public static String sortString(String s) {
		int n = s.length();
		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < n) {
			for (int i = 0; i < 26; i++) {
				if (count[i] > 0) {
					count[i]--;
					sb.append((char) (i + 'a'));
				}
			}
			for (int i = 25; i >= 0; i--) {
				if (count[i] > 0) {
					count[i]--;
					sb.append((char) (i + 'a'));
				}
			}
		}
		return sb.toString();
	}
}
