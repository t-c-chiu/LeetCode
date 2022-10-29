package medium;

public class MinimizeXOR {
	
	public static void main(String[] args) {
		int res = minimizeXor(25, 72);
		System.out.println(res);
	}
	
	/**
	 * 3 -> 011
	 * 5 -> 101
	 * <p>
	 * 1 -> 0001
	 * 12 -> 1100
	 */
	public static int minimizeXor(int num1, int num2) {
		int count1 = Integer.bitCount(num1);
		int count2 = Integer.bitCount(num2);
		if (count1 == count2) {
			return num1;
		} else if (count1 < count2) {
			count2 -= count1;
			for (int i = 0; i < 32 && count2 > 0; i++) {
				if ((num1 & 1 << i) == 0) {
					num1 ^= 1 << i;
					count2--;
				}
			}
			return num1;
		} else {
			count1 -= count2;
			for (int i = 0; i < 32 && count1 > 0; i++) {
				if ((num1 & 1 << i) != 0) {
					num1 ^= 1 << i;
					count1--;
				}
			}
			return num1;
		}
	}
}
