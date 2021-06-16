package medium;

public class FindKthBitInNthBinaryString {
	
	public static void main(String[] args) {
		char res = findKthBit(4, 11);
		System.out.println(res);
	}
	
	public static char findKthBit(int n, int k) {
		return buildString(n).charAt(k - 1);
	}
	
	private static StringBuilder buildString(int n) {
		if (n == 1) {
			return new StringBuilder("0");
		}
		
		StringBuilder builder = buildString(n - 1);
		int length = builder.length();
		builder.append('1');
		for (int i = length - 1; i >= 0; i--) {
			builder.append(builder.charAt(i) == '0' ? '1' : '0');
		}
		return builder;
	}
	
}
