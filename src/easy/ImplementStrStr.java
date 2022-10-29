package easy;

public class ImplementStrStr {
	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "issipi"));
		System.out.println(strStr("aa", "aaa"));
	}
	
	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0) && haystack.startsWith(needle, i)) {
				return i;
			}
		}
		return -1;
	}
}
