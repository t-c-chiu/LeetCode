package medium;

public class RemovingStarsFromAString {
	
	public static void main(String[] args) {
		String res = removeStars("leet**cod*e");
		System.out.println(res);
	}
	
	public static String removeStars(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '*') {
				builder.deleteCharAt(builder.length() - 1);
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
}
