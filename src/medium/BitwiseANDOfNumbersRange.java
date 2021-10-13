package medium;

public class BitwiseANDOfNumbersRange {
	
	public static void main(String[] args) {
		int res = rangeBitwiseAnd(26, 30);
		System.out.println(res);
	}
	
	
	/**
	 * 11010
	 * 11011
	 * 11100
	 * 11101
	 * 11110
	 */
	public static int rangeBitwiseAnd(int left, int right) {
		int bit = 0;
		while (left != right) {
			left >>= 1;
			right >>= 1;
			bit++;
		}
		return left << bit;
	}
}
