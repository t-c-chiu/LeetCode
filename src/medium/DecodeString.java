package medium;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		DecodeString test = new DecodeString();
		System.out.println(test.decodeString("3[a]2[bc]"));
		System.out.println(test.decodeString("3[a2[c]]"));
		System.out.println(test.decodeString("2[abc]3[cd]ef"));
	}
	
	public String decodeString(String s) {
		String cur = "";
		Stack<Integer> countStack = new Stack<>();
		Stack<String> curStack = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i))) {
				int count = 0;
				while (Character.isDigit(s.charAt(i)))
					count = count * 10 + Character.getNumericValue(s.charAt(i++));
				countStack.push(count);
			} else if (s.charAt(i) == '[') {
				curStack.push(cur);
				cur = "";
				i++;
			} else if (s.charAt(i) == ']') {
				StringBuilder temp = new StringBuilder(curStack.pop());
				int times = countStack.pop();
				for (int j = 0; j < times; j++)
					temp.append(cur);
				cur = temp.toString();
				i++;
			} else
				cur += s.charAt(i++);
		}
		return cur;
	}
}
