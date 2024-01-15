package easy;

public class ValidWordAbbreviation {
	
	public static void main(String[] args) {
		boolean res = validWordAbbreviation("internationalization", "i12iz4n");
		System.out.println(res);
	}
	
	public static boolean validWordAbbreviation(String word, String abbr) {
		int m = word.length(), n = abbr.length(), i = 0, j = 0;
		while (i < m && j < n) {
			char c = abbr.charAt(j);
			if (Character.isDigit(c)) {
				if (c == '0') {
					return false;
				}
				int num = 0;
				while (j < n && Character.isDigit(abbr.charAt(j))) {
					num = num * 10 + abbr.charAt(j) - '0';
					j++;
				}
				if (i + num > m) {
					return false;
				}
				i += num;
			} else {
				if (c != word.charAt(i)) {
					return false;
				}
				j++;
				i++;
			}
		}
		return i == m && j == n;
	}
	
}
