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
		String res = "";
		int i = 0;
		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i))) {
				int count = 0;
				while (Character.isDigit(s.charAt(i))) {
					count = count * 10 + s.charAt(i) - '0';
					i++;
				}
				countStack.push(count);
			} else if (s.charAt(i) == '[') {
				resStack.push(res);
				res = "";
				i++;
			} else if (s.charAt(i) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int n = countStack.pop();
				for (int j = 0; j < n; j++) {
					temp.append(res);
				}
				res = temp.toString();
				i++;
			} else {
				res += s.charAt(i++);
			}
		}
		return res;
	}
}
