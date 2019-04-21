package easy;

public class Buddy_Strings {
	
	public static void main(String[] args) {
		Buddy_Strings test = new Buddy_Strings();
		System.out.println(test.buddyStrings("ab", "ba"));
		System.out.println(test.buddyStrings("ab", "ab"));
		System.out.println(test.buddyStrings("aaaaaaabc", "aaaaaaacb"));
		System.out.println(test.buddyStrings("aa", "aa"));
	}
	
	public boolean buddyStrings(String A, String B) {
		int len = A.length();
		if (len != B.length())
			return false;
		if (A.equals(B)) {
			int[] count = new int[26];
			for (int i = 0; i < len; i++) {
				if (count[A.charAt(i) - 'a']++ > 0)
					return true;
			}
			return false;
		}
		Character prevA = null, prevB = null;
		for (int i = 0; i < A.length(); i++) {
			char a = A.charAt(i), b = B.charAt(i);
			if (a != b) {
				if (prevA == null) {
					prevA = a;
					prevB = b;
				} else {
					return prevA == b && prevB == a && A.substring(i + 1).equals(B.substring(i + 1));
				}
			}
		}
		return false;
	}
}
