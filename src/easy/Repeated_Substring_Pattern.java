package easy;

public class Repeated_Substring_Pattern {
	public static void main(String[] args) {
		Repeated_Substring_Pattern test = new Repeated_Substring_Pattern();
		System.out.println(test.repeatedSubstringPattern("abab"));
		System.out.println(test.repeatedSubstringPattern("ababab"));
		System.out.println(test.repeatedSubstringPattern("aba"));
		System.out.println(test.repeatedSubstringPattern("abcabcabc"));
	}
	
	public boolean repeatedSubstringPattern(String s) {
		int len = s.length();
		for (int i = 1; i <= len / 2; i++) {
			if (len % i == 0) {
				String candidate = s.substring(0, i);
				StringBuilder builder = new StringBuilder();
				for (int j = 0; j < len / i; j++) {
					builder.append(candidate);
				}
				if (builder.toString().equals(s))
					return true;
			}
		}
		return false;
	}
}
