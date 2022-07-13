package easy;

public class AddBinary {
	
	public static void main(String[] args) {
		String res = addBinary("1010", "1011");
		System.out.println(res);
	}
	
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) {
				sum += a.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += b.charAt(j--) - '0';
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}
}
