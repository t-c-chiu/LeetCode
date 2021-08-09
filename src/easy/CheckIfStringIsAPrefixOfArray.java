package easy;

public class CheckIfStringIsAPrefixOfArray {
	
	public static void main(String[] args) {
		boolean res = isPrefixString("iloveleetcode", new String[]{"i", "love", "leetcode", "apples"});
		System.out.println(res);
	}
	
	public static boolean isPrefixString(String s, String[] words) {
		StringBuilder builder = new StringBuilder();
		for (String word : words) {
			builder.append(word);
			String cur = builder.toString();
			if (cur.equals(s)) {
				return true;
			}
			if (!s.contains(cur)) {
				return false;
			}
		}
		return false;
	}
}
