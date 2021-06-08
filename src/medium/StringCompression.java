package medium;

public class StringCompression {
	
	public static void main(String[] args) {
		int res = compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'd', 'e', 'e', 'a', 'a', 'z', 'a'});
		System.out.println(res);
	}
	
	public static int compress(char[] chars) {
		char c = chars[0];
		int count = 1;
		int j = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == c) {
				count++;
			} else {
				chars[j++] = c;
				j = appendCount(chars, j, count);
				c = chars[i];
				count = 1;
			}
		}
		chars[j++] = c;
		return appendCount(chars, j, count);
	}
	
	private static int appendCount(char[] chars, int i, int count) {
		if (count > 1) {
			String countStr = String.valueOf(count);
			for (int k = 0; k < countStr.length(); k++) {
				chars[i++] = countStr.charAt(k);
			}
		}
		return i;
	}
}
