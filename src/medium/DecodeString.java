package medium;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}
	
	public static String decodeString(String s) {
		Stack<String> stringStack = new Stack<>();
		Stack<Integer> countStack = new Stack<>();
		int i = 0;
		String res = "";
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int count = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					count = count * 10 + s.charAt(i) - '0';
					i++;
				}
				countStack.push(count);
			} else if (Character.isLetter(c)) {
				res += c;
				i++;
			} else if (c == '[') {
				stringStack.push(res);
				res = "";
				i++;
			} else {
				int times = countStack.pop();
				StringBuilder sb = new StringBuilder(stringStack.pop());
				for (int j = 0; j < times; j++) {
					sb.append(res);
				}
				res = sb.toString();
				i++;
			}
		}
		return res;
	}
}
