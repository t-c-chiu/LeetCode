package easy;

public class AddStrings {
	public static void main(String[] args) {
		System.out.println(addStrings("1", "9"));
	}
	
	public static String addStrings(String num1, String num2) {
		StringBuilder builder = new StringBuilder();
		int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
		while (i >= 0 && j >= 0) {
			int a = num1.charAt(i) - '0';
			int b = num2.charAt(j) - '0';
			int sum = a + b + carry;
			carry = sum / 10;
			builder.append(sum % 10);
			i--;
			j--;
		}
		while (i >= 0) {
			int sum = num1.charAt(i) - '0' + carry;
			carry = sum / 10;
			builder.append(sum % 10);
			i--;
		}
		while (j >= 0) {
			int sum = num2.charAt(j) - '0' + carry;
			carry = sum / 10;
			builder.append(sum % 10);
			j--;
		}
		if (carry == 1) {
			builder.append('1');
		}
		return builder.reverse().toString();
	}
	
}
