package medium;

public class NextGreaterElementIII {
	
	public static void main(String[] args) {
		int res = nextGreaterElement(2147483486);
		System.out.println(res);
	}
	
	public static int nextGreaterElement(int n) {
		char[] chars = String.valueOf(n).toCharArray();
		for (int i = chars.length - 2; i >= 0; i--) {
			if (chars[i] < chars[i + 1]) {
				for (int j = chars.length - 1; j > i; j--) {
					if (chars[j] > chars[i]) {
						swap(chars, i, j);
						reverse(chars, i + 1);
						long res = Long.parseLong(String.valueOf(chars));
						return res > Integer.MAX_VALUE ? -1 : (int) res;
					}
				}
			}
		}
		return -1;
	}
	
	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
	
	private static void reverse(char[] chars, int start) {
		int end = chars.length - 1;
		while (start < end) {
			swap(chars, start++, end--);
		}
	}
	
}
