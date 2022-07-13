package easy;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String res = longestCommonPrefix(new String[]{"flow", "flower", "flight"});
		System.out.println(res);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || c != strs[j].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
//	public static String longestCommonPrefix(String[] strs) {
//		String prefix = strs[0];
//		for (int i = 1; i < strs.length; i++) {
//			prefix = findPrefix(prefix, strs[i]);
//			if (prefix.isEmpty()) {
//				return "";
//			}
//		}
//		return prefix;
//	}
//
//	private static String findPrefix(String s1, String s2) {
//		while (!s1.startsWith(s2)) {
//			s2 = s2.substring(0, s2.length() - 1);
//		}
//		return s2;
//	}
}
