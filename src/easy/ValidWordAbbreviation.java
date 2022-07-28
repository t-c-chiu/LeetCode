package easy;

public class ValidWordAbbreviation {
	
	public static void main(String[] args) {
		boolean res = validWordAbbreviation("a", "01");
		System.out.println(res);
	}
	
	public static boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0, m = word.length(), n = abbr.length();
		while (i < m && j < n) {
			char c1 = word.charAt(i), c2 = abbr.charAt(j);
			if (Character.isDigit(c2)) {
				if (c2 == '0') {
					return false;
				}
				int skip = 0;
				while (j < n && Character.isDigit(abbr.charAt(j))) {
					skip = skip * 10 + abbr.charAt(j) - '0';
					j++;
				}
				i += skip;
			} else if (c1 != c2) {
				return false;
			} else {
				i++;
				j++;
			}
		}
		return i == m && j == n;
	}
}
