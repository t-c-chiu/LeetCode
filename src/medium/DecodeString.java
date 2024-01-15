package medium;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}
	
	public static String decodeString(String s) {
		StringBuilder builder = new StringBuilder();
		Stack<Integer> countStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
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
				if (c == '[') {
					strStack.push(builder.toString());
					builder = new StringBuilder();
				} else if (c == ']') {
					int count = countStack.pop();
					StringBuilder temp = new StringBuilder(strStack.pop());
					for (int j = 0; j < count; j++) {
						temp.append(builder);
					}
					builder = temp;
				} else {
					builder.append(c);
				}
				i++;
			}
		}
		return builder.toString();
	}
}
