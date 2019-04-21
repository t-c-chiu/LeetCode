package easy;

public class Implement_strStr {
	public static void main(String[] args) {
		Implement_strStr test = new Implement_strStr();
		System.out.println(test.strStr("mississippi", "issipi"));
		System.out.println(test.strStr("aa", "aaa"));
	}
	
	public int strStr(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
		}
	}
}
