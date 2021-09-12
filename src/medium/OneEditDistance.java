package medium;

public class OneEditDistance {
	public static void main(String[] args) {
		boolean res = isOneEditDistance("", "");
		System.out.println(res);
	}
	
	public static boolean isOneEditDistance(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		if (Math.abs(sLen - tLen) > 1) {
			return false;
		}
		if (sLen > tLen) {
			return isOneEditDistance(t, s);
		}
		for (int i = 0; i < sLen; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (sLen == tLen) {
					return s.substring(i + 1).equals(t.substring(i + 1));
				} else {
					return s.substring(i).equals(t.substring(i + 1));
				}
			}
		}
		return sLen != tLen;
	}
//	public static boolean isOneEditDistance(String s, String t) {
//		int sLen = s.length();
//		int tLen = t.length();
//		if (Math.abs(sLen - tLen) > 1) {
//			return false;
//		}
//		if (sLen == tLen) {
//			return isOneCharacterDifferent(s, t);
//		}
//		if (sLen > tLen) {
//			return isOneEditDistance(t, s);
//		}
//		return isOneCharacterAdded(s, t);
//	}
//
//	private static boolean isOneCharacterDifferent(String s, String t) {
//		boolean hasDiff = false;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) != t.charAt(i)) {
//				if (hasDiff) {
//					return false;
//				}
//				hasDiff = true;
//			}
//		}
//		return hasDiff;
//	}
//
//	private static boolean isOneCharacterAdded(String s, String t) {
//		int i = 0;
//		int j = 0;
//		while (i < s.length() && j < t.length()) {
//			if (s.charAt(i) == t.charAt(j)) {
//				i++;
//			}
//			j++;
//		}
//		return i == s.length() && j >= t.length() - 1;
//	}
}
