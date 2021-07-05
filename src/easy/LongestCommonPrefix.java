package easy;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String res = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
		System.out.println(res);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			prefix = findPrefix(prefix, strs[i]);
			if (prefix.isEmpty()) {
				return "";
			}
		}
		return prefix;
	}
	
	private static String findPrefix(String s1, String s2) {
		while (s1.indexOf(s2) != 0) {
			s2 = s2.substring(0, s2.length() - 1);
			if (s2.isEmpty()) {
				return "";
			}
		}
		return s2;
	}
}
