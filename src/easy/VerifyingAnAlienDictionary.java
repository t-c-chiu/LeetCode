package easy;

public class VerifyingAnAlienDictionary {
	
	public static void main(String[] args) {
		boolean res = isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz");
		System.out.println(res);
	}
	
	public static boolean isAlienSorted(String[] words, String order) {
		int[] newOrder = new int[26];
		for (int i = 0; i < order.length(); i++) {
			newOrder[order.charAt(i) - 'a'] = i;
		}
		for (int i = 1; i < words.length; i++) {
			if (!isInOrder(words[i - 1], words[i], newOrder)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isInOrder(String s1, String s2, int[] order) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		int minLen = Math.min(s1Len, s2Len);
		for (int i = 0; i < minLen; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (c1 != c2) {
				return order[c1 - 'a'] < order[c2 - 'a'];
			}
		}
		return s1Len <= s2Len;
	}
}
