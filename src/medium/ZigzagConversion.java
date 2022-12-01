package medium;

public class ZigzagConversion {
	
	public static void main(String[] args) {
		String res = convert("PAYPALISHIRING", 3);
		System.out.println(res);
	}
	
	public static String convert(String s, int numRows) {
		StringBuilder[] builders = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			builders[i] = new StringBuilder();
		}
		int i = 0, n = s.length();
		while (i < n) {
			for (int j = 0; j < numRows && i < n; j++) {
				builders[j].append(s.charAt(i++));
			}
			for (int j = numRows - 2; j > 0 && i < n; j--) {
				builders[j].append(s.charAt(i++));
			}
		}
		StringBuilder res = new StringBuilder();
		for (int j = 0; j < numRows; j++) {
			res.append(builders[j]);
		}
		return res.toString();
	}
}
