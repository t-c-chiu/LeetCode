package medium;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}
	
	public static String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		int i = 0, n = s.length();
		while (i < n) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < n && Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				countStack.push(num);
			} else {
				if (Character.isLetter(c)) {
					builder.append(c);
				} else if (c == '[') {
					strStack.push(builder.toString());
					builder = new StringBuilder();
				} else {
					StringBuilder temp = new StringBuilder(strStack.pop());
					for (int j = countStack.pop(); j > 0; j--) {
						temp.append(builder);
					}
					builder = temp;
				}
				i++;
			}
		}
		return builder.toString();
	}
}
