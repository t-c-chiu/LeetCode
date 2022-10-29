package easy;

public class LicenseKeyFormatting {
	
	public static void main(String[] args) {
		String res = licenseKeyFormatting("2-5g-3-J", 2);
		System.out.println(res);
	}
	
	public static String licenseKeyFormatting(String s, int k) {
		s = s.toUpperCase();
		StringBuilder builder = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != '-') {
				temp.append(s.charAt(i));
			}
			if (temp.length() == k) {
				builder.append(temp).append('-');
				temp = new StringBuilder();
			}
		}
		if (temp.isEmpty() && !builder.isEmpty()) {
			builder.deleteCharAt(builder.length() - 1);
		}
		builder.append(temp);
		return builder.reverse().toString();
	}
}
