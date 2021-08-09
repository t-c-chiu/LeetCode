package easy;

public class AddStrings {
	public static void main(String[] args) {
		System.out.println(new AddStrings().addStrings("1", "9"));
	}
	
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		for (int i = num1.length() - 1, j = num2.length() - 1, carry = 0; i >= 0 || j >= 0 || carry == 1; i--, j--) {
			int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			int sum = n1 + n2 + carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}
		return sb.reverse().toString();
	}
}
