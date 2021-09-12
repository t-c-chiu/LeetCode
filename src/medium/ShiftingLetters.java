package medium;

public class ShiftingLetters {
	
	public static void main(String[] args) {
		String res = shiftingLetters("z", new int[]{52});
		System.out.println(res);
	}
	
	public static String shiftingLetters(String s, int[] shifts) {
		int n = s.length();
		StringBuilder builder = new StringBuilder(n);
		for (int i = n - 2; i >= 0; i--) {
			shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
		}
		for (int i = 0; i < n; i++) {
			builder.append(shift(s.charAt(i), shifts[i]));
		}
		return builder.toString();
	}
	
	private static char shift(char c, int shift) {
		c += shift % 26;
		return c <= 'z' ? c : (char) (c - 'z' + 'a' - 1);
	}
}
