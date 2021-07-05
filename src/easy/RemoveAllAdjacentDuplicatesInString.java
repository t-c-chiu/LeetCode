package easy;

public class RemoveAllAdjacentDuplicatesInString {
	
	public static void main(String[] args) {
		String res = removeDuplicates("abbaca");
		System.out.println(res);
	}
	
	public static String removeDuplicates(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int j = builder.length() - 1;
			if (j >= 0 && c == builder.charAt(j)) {
				builder.deleteCharAt(j);
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
}
