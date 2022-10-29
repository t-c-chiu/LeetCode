package medium;

public class IntegerToRoman {
	
	public static void main(String[] args) {
		String res = intToRoman(1994);
		System.out.println(res);
	}
	
	/**
	 * Symbol       Value
	 * I             1
	 * V             5
	 * X             10
	 * L             50
	 * C             100
	 * D             500
	 * M             1000
	 */
	public static String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();
		helper(builder, num / 1000, "M", "", "", "");
		num %= 1000;
		helper(builder, num / 100, "C", "CD", "D", "CM");
		num %= 100;
		helper(builder, num / 10, "X", "XL", "L", "XC");
		num %= 10;
		helper(builder, num, "I", "IV", "V", "IX");
		return builder.toString();
	}
	
	private static void helper(StringBuilder builder, int i, String one, String four, String five, String nine) {
		if (i == 4) {
			builder.append(four);
		} else if (i == 9) {
			builder.append(nine);
		} else {
			if (i >= 5) {
				builder.append(five);
			}
			for (int j = 0; j < i % 5; j++) {
				builder.append(one);
			}
		}
	}
	
}
