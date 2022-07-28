package easy;

public class RemoveAllAdjacentDuplicatesInString {
	
	public static void main(String[] args) {
		String res = removeDuplicates("abbaca");
		System.out.println(res);
	}
	
	public static String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int last = sb.length() - 1;
			if (!sb.isEmpty() && sb.charAt(last) == c) {
				sb.deleteCharAt(last);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
