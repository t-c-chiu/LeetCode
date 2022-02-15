package medium;

public class StringCompression {
	
	public static void main(String[] args) {
		char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
		int res = compress(chars);
		System.out.println(res);
		for (char c : chars) {
			System.out.print(c + " ");
		}
	}
	
	public static int compress(char[] chars) {
		int i = 0, j = 0, n = chars.length;
		while (i < n) {
			char cur = chars[i];
			int count = 0;
			while (i < n && cur == chars[i]) {
				count++;
				i++;
			}
			chars[j++] = cur;
			if (count > 1) {
				for (char digit : String.valueOf(count).toCharArray()) {
					chars[j++] = digit;
				}
			}
		}
		return j;
	}
}
