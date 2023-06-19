package medium;

public class LexicographicallySmallestStringAfterSubstringOperation {
	
	public static void main(String[] args) {
		String res = smallestString("cbabc");
		System.out.println(res);
		res = smallestString("acbbc");
		System.out.println(res);
		res = smallestString("leetcode");
		System.out.println(res);
	}
	
	public static String smallestString(String s) {
		char[] chars = s.toCharArray();
		int start = 0, n = chars.length;
		while (start < n && chars[start] == 'a') {
			start++;
		}
		if (start == n) {
			chars[n - 1] = 'z';
			return String.valueOf(chars);
		}
		int end = start;
		while (end < n && chars[end] != 'a') {
			end++;
		}
		for (int i = start; i < end; i++) {
			chars[i]--;
		}
		return String.valueOf(chars);
	}
}
