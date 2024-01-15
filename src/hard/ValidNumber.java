package hard;

public class ValidNumber {
	
	public static void main(String[] args) {
		boolean res = isNumber("53.5e93");
		System.out.println(res);
	}
	
	public static boolean isNumber(String s) {
		boolean hasDigit = false;
		boolean dotSeen = false;
		boolean eSeen = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+' || c == '-') {
				if (i != 0 && Character.toLowerCase(s.charAt(i - 1)) != 'e') {
					return false;
				}
			} else if (c == 'e' || c == 'E') {
				if (eSeen || !hasDigit) {
					return false;
				}
				eSeen = true;
				dotSeen = true;
				hasDigit = false;
			} else if (c == '.') {
				if (dotSeen) {
					return false;
				}
				dotSeen = true;
			} else if (Character.isDigit(c)) {
				hasDigit = true;
			} else {
				return false;
			}
		}
		return hasDigit;
	}
	
}
