package medium;

public class CustomSortString {
	
	public static void main(String[] args) {
		String res = customSortString("cba", "abcd");
		System.out.println(res);
	}
	
	public static String customSortString(String order, String str) {
		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < order.length(); i++) {
			char c = order.charAt(i);
			for (int j = 0; j < count[c - 'a']; j++) {
				builder.append(c);
			}
			count[c - 'a'] = 0;
		}
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				builder.append((char) (i + 'a'));
			}
		}
		return builder.toString();
	}
}
