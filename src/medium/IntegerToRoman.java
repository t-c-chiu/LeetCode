package medium;

public class IntegerToRoman {
	
	public static void main(String[] args) {
		String res = intToRoman(1994);
		System.out.println(res);
	}
	
	public static String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();
		transform(num / 1000, builder, "", "", "", "M");
		num %= 1000;
		transform(num / 100, builder, "CD", "CM", "D", "C");
		num %= 100;
		transform(num / 10, builder, "XL", "XC", "L", "X");
		num %= 10;
		transform(num, builder, "IV", "IX", "V", "I");
		return builder.toString();
	}
	
	
	private static void transform(int num, StringBuilder builder, String four, String nine, String five, String one) {
		if (num == 0) {
			return;
		}
		
		if (num == 4) {
			builder.append(four);
		} else if (num == 9) {
			builder.append(nine);
		} else {
			if (num >= 5) {
				builder.append(five);
			}
			for (int i = 0; i < num % 5; i++) {
				builder.append(one);
			}
		}
	}
}
