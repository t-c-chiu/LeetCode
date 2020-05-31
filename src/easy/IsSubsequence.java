package easy;

public class IsSubsequence {
	
	public static void main(String[] args) {
		IsSubsequence test = new IsSubsequence();
		System.out.println(test.isSubsequence("abc", "ahbgdc"));
		System.out.println(test.isSubsequence("axc", "ahbgdc"));
	}
	
	public boolean isSubsequence(String s, String t) {
		if (s.isEmpty())
			return true;
		
		for (int i = 0, j = 0; i < t.length(); i++) {
			if (t.charAt(i) == s.charAt(j) && ++j == s.length())
				return true;
		}
		return false;
	}
}
