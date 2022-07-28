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
		Stack<String> resStack = new Stack<>();
		StringBuilder res = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				countStack.push(num);
			} else {
				if (Character.isLetter(c)) {
					res.append(c);
				} else if (c == '[') {
					resStack.push(res.toString());
					res = new StringBuilder();
				} else if (c == ']') {
					StringBuilder temp = new StringBuilder(resStack.pop());
					for (int j = countStack.pop(); j > 0; j--) {
						temp.append(res);
					}
					res = temp;
				}
				i++;
			}
		}
		return res.toString();
	}
}
