package easy;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(new ReverseString().reverseString("hello"));
	}
	
	public String reverseString(String s) {
		char[] chars = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = chars.length - 1; i >= 0; i--) {
			builder.append(chars[i]);
		}
		return builder.toString();
	}
}
