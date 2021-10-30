package easy;

public class FindTheDifference {
	
	public static void main(String[] args) {
		char res = findTheDifference("abcd", "dcbaf");
		System.out.println(res);
	}
	
	public static char findTheDifference(String s, String t) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res = res ^ s.charAt(i) ^ t.charAt(i);
		}
		return (char) (res ^ t.charAt(t.length() - 1));
	}
}
