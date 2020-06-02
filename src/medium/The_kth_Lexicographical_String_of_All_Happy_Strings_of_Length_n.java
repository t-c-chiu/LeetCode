package medium;

import java.util.ArrayList;
import java.util.List;

public class The_kth_Lexicographical_String_of_All_Happy_Strings_of_Length_n {
	
	public static void main(String[] args) {
		The_kth_Lexicographical_String_of_All_Happy_Strings_of_Length_n test = new The_kth_Lexicographical_String_of_All_Happy_Strings_of_Length_n();
		String res = test.getHappyString(3, 9);
		System.out.println(res);
	}
	
	public String getHappyString(int n, int k) {
		List<String> happyStrings = new ArrayList<>();
		buildHappyStrings(happyStrings, new char[]{'a', 'b', 'c'}, n, "");
		return happyStrings.size() >= k ? happyStrings.get(k - 1) : "";
	}
	
	private void buildHappyStrings(List<String> happyStrings, char[] chars, int n, String s) {
		if (n == s.length()) {
			happyStrings.add(s);
			return;
		}
		
		for (char c : chars) {
			if (s.isEmpty() || c != s.charAt(s.length() - 1)) {
				buildHappyStrings(happyStrings, chars, n, s + c);
			}
		}
	}
}
