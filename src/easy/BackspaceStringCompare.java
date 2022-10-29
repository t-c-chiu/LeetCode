package easy;

public class BackspaceStringCompare {
	
	public static void main(String[] args) {
		System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("nzp#o#g", "b#nzp#o#g"));
		System.out.println(backspaceCompare("a#c", "b"));
	}
	
	public static boolean backspaceCompare(String s, String t) {
		int i = s.length() - 1, j = t.length() - 1;
		while (i >= 0 || j >= 0) {
			int back = 0;
			while (i >= 0 && (s.charAt(i) == '#' || back > 0)) {
				if (s.charAt(i--) == '#') {
					back++;
				} else {
					back--;
				}
			}
			back = 0;
			while (j >= 0 && (t.charAt(j) == '#' || back > 0)) {
				if (t.charAt(j--) == '#') {
					back++;
				} else {
					back--;
				}
			}
			if (i == -1 && j == -1) {
				return true;
			}
			if (i == -1 || j == -1 || s.charAt(i) != t.charAt(j)) {
				return false;
			}
			i--;
			j--;
		}
		return i == -1 && j == -1;
	}
}
