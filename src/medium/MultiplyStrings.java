package medium;

public class MultiplyStrings {
	
	public static void main(String[] args) {
		String res = multiply("123", "456");
		System.out.println(res);
	}
	
	/**
	 * 1 2 3
	 * 4 5 6
	 * <p>
	 * [4, 5+8, 6+10+12, 12+15, 18] = [4, 13, 28, 27, 18] = [5, 6, 0, 8 ,8]
	 */
	public static String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		int[] res = new int[num1.length() + num2.length() - 1];
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				res[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		for (int i = res.length - 1; i > 0; i--) {
			res[i - 1] += res[i] / 10;
			res[i] %= 10;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			if (i == 0 && sb.isEmpty()) {
				continue;
			}
			sb.append(i);
		}
		return sb.toString();
	}
	
}
