package medium;

public class MultiplyStrings {
	
	public static void main(String[] args) {
		String res = multiply("123", "456");
		System.out.println(res);
	}
	
	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		
		int m = num1.length(), n = num2.length();
		int[] res = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				res[i + j + 1] += product;
				res[i + j] += res[i + j + 1] / 10;
				res[i + j + 1] = res[i + j + 1] % 10;
			}
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i : res) {
			if (builder.length() == 0 && i == 0) {
				continue;
			}
			builder.append(i);
		}
		return builder.toString();
	}
	
}
