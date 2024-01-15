package medium;

public class MaximumSwap {
	
	public static void main(String[] args) {
		int res = maximumSwap(10909091);
		System.out.println(res);
	}
	
	public static int maximumSwap(int num) {
		int[] pos = new int[10];
		char[] chars = String.valueOf(num).toCharArray();
		for (int i = 0; i < chars.length; i++) {
			pos[chars[i] - '0'] = i;
		}
		for (int i = 0; i < chars.length; i++) {
			for (char j = 9; j > chars[i] - '0'; j--) {
				if (pos[j] > i) {
					swap(chars, i, pos[j]);
					return Integer.parseInt(String.valueOf(chars));
				}
			}
		}
		return num;
	}
	
	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
